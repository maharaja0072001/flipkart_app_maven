package org.abc.model.product;

import org.abc.ProductCategory;

/**
 * <p>
 * Represents the model for laptop.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class Laptop extends Product {

    private final String model;

    public String getModel() {
            return model;
    }

    public Laptop(final String brandName, final String model, final float price, final int quantity) {
        super(ProductCategory.LAPTOP, price, brandName, quantity);
        this.model = model;
    }

    public String toString() {
        return String.format("%s : %s - Rs : %.2f", super.getBrandName(), model, super.getPrice());
    }
}

