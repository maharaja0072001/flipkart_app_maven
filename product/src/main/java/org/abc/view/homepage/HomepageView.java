package org.abc.view.homepage;

import org.abc.ProductCategory;
import org.abc.authentication.view.AuthenticationView;
import org.abc.singleton_scanner.SingletonScanner;
import org.abc.view.common_view.View;
import org.abc.controller.inventory.InventoryController;
import org.abc.authentication.model.User;
import org.abc.view.order.OrderView;
import org.abc.model.product.Product;
import org.abc.InventoryManager;
import org.abc.validation.Validator;
import org.abc.pageview.PageViewer;
import org.abc.view.wishlist.WishlistView;
import org.abc.view.cart.CartView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * <p>
 * Shows the homepage of the flipkart application to the user to shop products.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class HomepageView extends View implements PageViewer {

    private static HomepageView homePageView;
    private static final AuthenticationView AUTHENTICATION_VIEW = AuthenticationView.getInstance();
    private static final FilterMenuView FILTER_MENU_VIEW = FilterMenuView.getInstance();
    private static final InventoryController INVENTORY_CONTROLLER = InventoryController.getInstance();
    private static final List<Product> MOBILES = INVENTORY_CONTROLLER.getItemsByCategory(ProductCategory.MOBILE);
    private static final List<Product> LAPTOPS = INVENTORY_CONTROLLER.getItemsByCategory(ProductCategory.LAPTOP);
    private static final List<Product> CLOTHES = INVENTORY_CONTROLLER.getItemsByCategory(ProductCategory.CLOTHES);
    private static final Validator VALIDATOR = Validator.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CartView.class);

    /**
     * <p>
     * Default constructor of HomepageView class. Kept private to restrict from creating object outside this class.
     * </p>
     */
    private HomepageView() {}

    /**
     * <p>
     * Creates a single object of HomepageView class and returns it.
     * </p>
     *
     * @return the single instance of HomepageView class.
     */
    public static HomepageView getInstance() {
        return homePageView == null ? homePageView = new HomepageView() : homePageView;
    }

    /**
     * <p>
     * Shows the home page of the flipkart application to the user for shopping the products.
     * </p>
     *
     * @param user Refers the current {@link User}.
     */
    public void showHomePage(final User user) {
        InventoryManager.getInstance().addAllItems();
        LOGGER.info("1.Mobiles\n2.Laptops\n3.Clothes\n4.Cart\n5.Wishlist\n6.My Orders\n7.Profile\n8.Logout");

        switch (getChoice()) {
            case 1:
                showItems(MOBILES);
                addToCartOrWishlist(user, MOBILES);
                break;
            case 2:
                showItems(LAPTOPS);
                addToCartOrWishlist(user, LAPTOPS);
                break;
            case 3:
                showItems(CLOTHES);
                addToCartOrWishlist(user, CLOTHES);
                break;
            case 4:
                CartView.getInstance().viewCart(user);
                break;
            case 5:
                WishlistView.getInstance().viewWishlist(user);
                break;
            case 6:
                OrderView.getInstance().viewAndCancelOrder(user);
                break;
            case 7:
                AUTHENTICATION_VIEW.viewAndEditProfile(user);
                break;
            case 8:
                LOGGER.info("Logged out successfully");
                AUTHENTICATION_VIEW.showAuthenticationPage();
                break;
            default:
                System.out.println("Enter a valid choice");
                showHomePage(user);
        }
    }

    /**
     * <p>
     * Gets choice from the user to add to cart or wishlist or show filtered products to the user
     * </p>
     *
     * @param user Refers the current {@link User}.
     * @param products Refers the products in the inventory.
     */
    private void addToCartOrWishlist(final User user, final List<Product> products) {
        System.out.println("Enter the product id to add to cart or wishlist or '#' to show filter menu or press '$' to go back");
        final String choice = SingletonScanner.getScanner().nextLine().trim();

        if (VALIDATOR.checkToGoBack(choice)) {
            showHomePage(user);
        }

        if (VALIDATOR.toShowFilterMenu(choice)) {
            FILTER_MENU_VIEW.showFilterMenu(user, products);
        } else {
            try {
                final int index = Integer.parseInt(choice);

                if (index > products.size()) {
                    System.out.println("Enter a valid product id");
                    addToCartOrWishlist(user, products);
                } else {
                    final Product selectedItem = products.get(index - 1);

                    FILTER_MENU_VIEW.addItemToCartOrWishlist(selectedItem, user, products);
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid product id");
                addToCartOrWishlist(user, products);
            }
        }
    }

    /**
     * <p>
     * Shows the homepage of the user.
     * </p>
     *
     * @param user Refers the current {@link User}.
     */
    @Override
    public void viewPage(Object user) {
        showHomePage((User) user);
    }
}
