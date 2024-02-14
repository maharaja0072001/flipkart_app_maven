package org.abc.controller.wishlist;

import org.abc.authentication.model.User;
import org.abc.model.wishlist.Wishlist;
import org.abc.model.product.Product;
import org.abc.service.wishlist.impl2.WishlistServiceImpl;
import org.abc.service.wishlist.WishlistService;

import java.util.Objects;

/**
 * <p>
 * Handles requests and responses from WishlistView clas and WishlistService class.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class WishlistController {

    private static WishlistController wishlistController;
    private static final WishlistService WISHLIST_SERVICE = WishlistServiceImpl.getInstance();

    /**
     * <p>
     * Default constructor of the WishlistController class. Kept private to restrict from creating object from outside of this class.
     * </p>
     */
    private WishlistController() {}

    /**
     * <p>
     * Creates a single object of WishlistController Class and returns it.
     * </p>
     *
     * @return returns the single instance of WishlistController Class.
     */
    public static WishlistController getInstance() {
        return Objects.isNull(wishlistController) ? wishlistController = new WishlistController() : wishlistController;
    }

    /**
     * <p>
     * Adds the product to the wishlist of the specified user.
     * </p>
     *
     * @param product Refers the product to be added
     * @param user Refers the user
     * @return the wishlist of the user.
     */
    public boolean addItem(final Product product, final User user) {
        return WISHLIST_SERVICE.addItem(product, user);
    }

    /**
     * <p>
     * Removes the product from the wishlist of the specified user.
     * </p>
     *
     * @param product Refers the product to be removed.
     * @param user Refers the user
     */
    public void removeItem(final Product product, final User user) {
        WISHLIST_SERVICE.removeItem(product, user);
    }

    /**
     * <p>
     * Gets the wishlist of the specified user id and returns it.
     * </p>
     *
     * @param user Refers the user who owns the cart.
     * @return the wishlist of the user.
     */
    public Wishlist getWishlist(final User user) {
        return WISHLIST_SERVICE.getWishlist(user);
    }
}
