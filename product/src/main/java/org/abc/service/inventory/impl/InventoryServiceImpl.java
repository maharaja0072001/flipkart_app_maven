package org.abc.service.inventory.impl;

import org.abc.model.product.Product;
import org.abc.service.inventory.InventoryService;
import org.abc.ProductCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Provides the service for the Inventory. Responsible for storing all the products.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class InventoryServiceImpl implements InventoryService {

    private static InventoryService inventoryService;
    private static final List<Product> MOBILE_INVENTORY = new ArrayList<>();
    private static final List<Product> LAPTOP_INVENTORY = new ArrayList<>();
    private static final List<Product> CLOTHES_INVENTORY = new ArrayList<>();

    /**
     * <p>
     * Default constructor of InventoryServiceImpl class. Kept private to restrict from creating object outside this class.
     * </p>
     */
    private InventoryServiceImpl() {}

    /**
     * <p>
     * Creates a single object of InventoryServiceImpl class and returns it.
     * </p>
     *
     * @return the single instance of InventoryController class.
     */
    public static InventoryService getInstance() {
        return inventoryService == null ? inventoryService = new InventoryServiceImpl() : inventoryService;
    }

    /**
     * <p>
     * Adds the given products to the inventory.
     * </p>
     *
     * @param products Refers the {@link Product} to be added.
     */
    @Override
    public void addItem(final List<Product> products) {
        for (final Product product : products) {
            if (ProductCategory.MOBILE == product.getProductCategory()) {
                MOBILE_INVENTORY.add(product);
            }

            if (ProductCategory.LAPTOP == product.getProductCategory()) {
                LAPTOP_INVENTORY.add(product);
            }

            if (ProductCategory.CLOTHES == product.getProductCategory()) {
                CLOTHES_INVENTORY.add(product);
            }
        }
    }

    /**
     * <p>
     * Removes the given item from the inventory.
     * </p>
     *
     * @param product Refers the {@link Product} to be removed.
     */
    @Override
    public void removeItem(final Product product) {
        if (ProductCategory.MOBILE == product.getProductCategory()) {
           MOBILE_INVENTORY.remove(product);
        }

        if (ProductCategory.LAPTOP == product.getProductCategory()) {
            LAPTOP_INVENTORY.remove(product);
        }

        if (ProductCategory.LAPTOP == product.getProductCategory()) {
            CLOTHES_INVENTORY.remove(product);
        }
    }

    /**
     * <p>
     * Gets all the products from the inventory based on the category and returns it.
     * </p>
     *
     * @return all the {@link Product} from the inventory.
     */
    @Override
    public List<Product> getItemsByCategory(final ProductCategory productCategory) {
        switch (productCategory) {
            case MOBILE:
                return MOBILE_INVENTORY;
            case LAPTOP:
                return LAPTOP_INVENTORY;
            case CLOTHES:
                return CLOTHES_INVENTORY;
        }

        return null;
    }
}
