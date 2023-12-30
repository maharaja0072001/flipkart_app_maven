package org.abc.model.cart;

import org.abc.model.product.Product;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * Represents a cart for the user to add the items to the cart and placing the orders.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class Cart {

    private List<Product> cartItems;
    private float totalAmountInCart;

    public boolean addToCart(final Product product) {
        if (null == cartItems) {
            cartItems = new LinkedList<>();
        }

        if (!cartItems.contains(product)) {
            totalAmountInCart += product.getPrice();

            return cartItems.add(product);
        }

        return false;
    }

    public void removeFromCart(final Product item) {
        cartItems.remove(item);
        totalAmountInCart -= item.getPrice();
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public float getTotalAmount() {
        return totalAmountInCart;
    }
}
