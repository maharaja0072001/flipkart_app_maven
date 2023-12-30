package org.abc.service.inventory;

import org.abc.ProductCategory;
import org.abc.model.product.Product;

import java.util.List;

/**
 * <p>
 * Provides service for the Inventory.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public interface InventoryService {

    /**
     * <p>
     * Adds the products to the inventory.
     * </p>
     *
     * @param products Refers the {@link Product} to be added.
     */
    void addItem(final List<Product> products);

    /**
     * <p>
     * Removes the product from the inventory.
     * </p>
     *
     * @param product Refers the {@link Product} to be removed.
     */
    void removeItem(final Product product);

    /**
     * <p>
     * Gets all the products from the inventory based on the category and returns it.
     * </p>
     *
     * @return all the {@link Product} from the inventory.
     */
    List<Product> getItemsByCategory(final ProductCategory productCategory);
}
