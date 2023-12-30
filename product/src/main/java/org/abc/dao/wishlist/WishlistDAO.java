package org.abc.dao.wishlist;

import org.abc.authentication.model.User;
import org.abc.model.product.Product;
import org.abc.model.wishlist.Wishlist;

public interface WishlistDAO {

    /**
     * <p>
     * Adds the specific product to the wishlist
     * </p>
     *
     * @param user Refers the current {@link User}
     * @param product Refers {@link Product} to be added to the wishlist.
     * @return true if the product is added.
     */
    boolean addItem(final Product product, final User user);

    /**
     * <p>
     * Removes the specific product from the wishlist
     * </p>
     *
     * @param user Refers the current {@link User}
     * @param product Refers {@link Product} the product to be removed.
     */
    void removeItem(final Product product, final User user);

    /**
     * <p>
     * Gets the wishlist of the current user and returns it.
     * </p>
     *
     * @param user Refers the current {@link User}
     * @return the {@link Wishlist} of the user.
     */
    Wishlist getUserWishlist(final User user);
}