package org.abc.view.homepage;

import org.abc.authentication.model.User;
import org.abc.authentication.view.AuthenticationView;
import org.abc.singleton_scanner.SingletonScanner;
import org.abc.model.product.Product;
import org.abc.validation.Validator;
import org.abc.view.homepage.filter.Filter;
import org.abc.view.homepage.filter.RateFilter;
import org.abc.view.wishlist.WishlistView;
import org.abc.view.cart.CartView;
import org.abc.view.common_view.View;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * Shows the filter menu to get filtered items.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class FilterMenuView extends View {

    private static FilterMenuView filterMenuView;
    private static final CartView CART_VIEW = CartView.getInstance();
    private static final WishlistView WISHLIST_VIEW = WishlistView.getInstance();
    private static final Validator VALIDATOR = Validator.getInstance();
    private static final Filter RATE_FILTER = RateFilter.getInstance();
    private static final Scanner SCANNER = SingletonScanner.getScanner();
    private static final Logger LOGGER = LogManager.getLogger(AuthenticationView.class);

    /**
     * <p>
     * Default constructor of FilterMenuView class. Kept private to restrict from creating object outside this class.
     * </p>
     */
    private FilterMenuView() {}

    /**
     * <p>
     * Creates a single object of FilterMenuView class and returns it.
     * </p>
     *
     * @return the single instance of FilterMenuView class.
     */
    public static  FilterMenuView getInstance() {
        if (null == filterMenuView) {
            filterMenuView = new FilterMenuView();
        }

        return filterMenuView;
    }

    /**
     * <p>
     * Shows the filter menu to the user to filter the items presented in the inventory.
     * </p>
     *
     * @param user Refers the current {@link User}.
     * @param products Refers all the {@link Product} in the inventory.
     */
    public void showFilterMenu(final User user, final List<Product> products) {
        LOGGER.info("Filter By:[Press '$' to go back]\n1.Rate Low to High\n2.Rate High to Low\n3.Price");
        final int choice = getChoice();

        if (0 > choice)  {        //-1 is returned if back key is pressed
            return;
        }

        switch (choice) {
            case 1:
                final List<Product> itemsFilteredByLowToHigh = RATE_FILTER.sortLowToHigh(products);

                showItems(itemsFilteredByLowToHigh);

                while (true) {
                    final Product selectedItem = getSelectedItem(itemsFilteredByLowToHigh);

                    if (null == selectedItem) {
                        showFilterMenu(user, products);

                        return;
                    }
                    addItemToCartOrWishlist(selectedItem, user);
                }
            case 2:
                final List<Product> itemsFilteredByHighToLow = RATE_FILTER.sortHighToLow(products);

                showItems(itemsFilteredByHighToLow);

                while (true) {
                    final Product selectedItem = getSelectedItem(itemsFilteredByHighToLow);

                    if (null == selectedItem) {
                        showFilterMenu(user, products);

                        return;
                    }
                    addItemToCartOrWishlist(selectedItem, user);
                }
            case 3:
                int mimimumAmount;
                int maximumAmount;

               while (true) {
                   LOGGER.info("Enter minimum amount:");
                   String amount = SCANNER.nextLine().trim();

                   if (VALIDATOR.checkToGoBack(amount)) {
                       showFilterMenu(user,products);
                       return;
                   }

                   try {
                       mimimumAmount = Integer.parseInt(amount);
                       amount = SCANNER.nextLine().trim();

                       if (VALIDATOR.checkToGoBack(amount)) {
                           showFilterMenu(user,products);
                           return;
                       }

                       maximumAmount = Integer.parseInt(amount);

                       if (!(mimimumAmount < maximumAmount)) {
                           LOGGER.warn("Entered amount is invalid");
                           continue;
                       }
                       break;
                   } catch (final NumberFormatException exception) {
                       LOGGER.warn("Entered amount is invalid");
                   }
               }
                final List<Product> itemsFilteredByPrice = RATE_FILTER.sortByRange(products, mimimumAmount, maximumAmount);

                if (null == itemsFilteredByPrice) {
                    LOGGER.warn("No products found");
                    showFilterMenu(user, products);

                    return;
                }
                showItems(itemsFilteredByPrice);

                while (true) {
                    final Product selectedItem = getSelectedItem(itemsFilteredByPrice);

                    if (null == selectedItem) {    //null is returned if back key is pressed
                        showFilterMenu(user, products);

                        return;
                    }
                    addItemToCartOrWishlist(selectedItem, user);
                }
            default:
                LOGGER.warn("Enter a valid choice ");
                break;
        }
        showFilterMenu(user, products);
    }
    /**
     * <p>
     * Gets the choice from the user to add the product to the cart or wishlist.
     * </p>
     *
     * @param product Refers the {@link Product} to be added to cart or wishlist
     * @param user Refers the current {@link User}.
     */
    public void addItemToCartOrWishlist(final Product product, final User user) {
        LOGGER.info("Enter '1' to add to cart or '2' to add to wishlist. Press '$' to go back");
        final int choice = getChoice();

        if (-1 == choice) {    // -1 is returned if back key is pressed.
            return;
        }

        switch (choice) {
            case 1:
                CART_VIEW.addItem(product, user);
                break;
            case 2:
                WISHLIST_VIEW.addItem(product, user);
                break;
            default:
                LOGGER.warn("Invalid choice");
                addItemToCartOrWishlist(product, user);
                break;
        }
    }

    /**
     * <p>
     * Gets the specific item from the inventory which was selected by the user and return it.
     * </p>
     *
     * @return the {@link Product} selected by the user.
     * @param products Refers all the {@link Product} in the inventory .
     */
    public Product getSelectedItem(final List<Product> products) {
        LOGGER.info("Enter the product id : [Press '$' to go back]");
        final int index = getChoice();

        if (0 > index) {
            return null;
        }

        if (index > products.size() || index == 0) {
            System.out.println("Enter a valid product id");
            return getSelectedItem(products);
        }

        return products.get(index - 1);
    }
}