package org.abc.view.homepage.filter;

import org.abc.model.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Filters the products based on price high to low or low to high or between a price range.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class RateFilter implements Filter {

    private static RateFilter rateFilter;

    /**
     * <p>
     * Default constructor of RateFilter class. Kept private to restrict from creating object outside this class.
     * </p>
     */
    private RateFilter() {}

    /**
     * <p>
     * Creates a single object of RateFilter class and returns it.
     * </p>
     *
     * @return the single instance of RateFilter class.
     */
    public static RateFilter getInstance() {
        return rateFilter == null ? rateFilter = new RateFilter() : rateFilter;
    }

    /**
     * <p>
     * Filters the items present in the inventory based on price high to low and returns it.
     * </p>
     *
     * @param products Refer the items to be sorted.
     * @return the items filtered by price high to low.
     */
    public List<Product> sortHighToLow(final List<Product> products) {
        final ArrayList<Product> filteredItems = new ArrayList<>(products);

        filteredItems.sort(new RateComparator(true));

        return filteredItems;
    }

    /**
     * <p>
     * Filters the items present in the inventory based on price low to high and returns it.
     * </p>
     *
     * @param products Refer the items to be sorted.
     * @return all the products filtered by price from low to high.
     */
    public List<Product> sortLowToHigh(final List<Product> products) {
        final ArrayList<Product> filteredItems = new ArrayList<>(products);

        filteredItems.sort(new RateComparator(false));

        return filteredItems;
    }

    /**
     * <p>
     * Filters the inventory based on the price range given by the user and returns the filtered items.
     * </p>
     *
     * @return the filtered items of given price range.
     */
    public List<Product> sortByRange(final List<Product> products, final int minimumAmount, final int maximumAmount) {
        final ArrayList<Product> filteredItems = new ArrayList<>();

        for (final Product product : products) {
            if ((product.getPrice() >= minimumAmount)
                    && (product.getPrice() <= maximumAmount)) {
                filteredItems.add(product);
            }
        }

        return filteredItems;
    }
}