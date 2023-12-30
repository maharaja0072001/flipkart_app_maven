package org.abc;

/**
 * <p>
 * Provides the category of products available.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public enum ProductCategory {

    MOBILE(1), LAPTOP(2), CLOTHES(3);

    final int id;

    /**
     * <p>
     * Constructor of the enum.
     * </p>
     *
     * @param id Refers the id of the enum values
     */
    ProductCategory(final int id) {
       this.id = id;
    }
}
