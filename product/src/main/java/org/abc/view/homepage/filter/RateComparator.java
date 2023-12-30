package org.abc.view.homepage.filter;

import org.abc.model.product.Product;

import java.util.Comparator;

/**
 * <p>
 * Provides Comparator to compare the products based on their price.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class RateComparator implements Comparator<Product> {

    private final boolean highToLow;

    /**
     * <p>
     * Constructs RateComparator with sorting order based on boolean value highToLow.
     * If true then it compares products with price high to low  and if false it compares with low to high.
     * </p>
     *
     * @param highToLow Refers the boolean value of sort order high to low.
     */
    public RateComparator(final boolean highToLow) {
        this.highToLow = highToLow;
    }

    /**
     * <p>
     * Compares two product based on their price and return the subtracted value
     * </p>
     *
     * @return the value got by subtracting the price of two products.
     */
    @Override
    public int compare(final Product product, final Product otherProduct) {
        if (highToLow) {
            return (int) (otherProduct.getPrice() - product.getPrice());
        } else {
            return (int) (product.getPrice() - otherProduct.getPrice());
        }
    }
}