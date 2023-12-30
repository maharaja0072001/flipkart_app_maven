package org.abc;

/**
 * <p>
 * Provides the status of order.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public enum OrderStatus {

    PLACED(1), DELIVERED(2), IN_TRANSIT(3), CANCELLED(4);

    final int id;

    /**
     * <p>
     * Constructor of the enum.
     * </p>
     *
     * @param id Refers the id of the enum values
     */
    OrderStatus(final int id) {
        this.id = id;
    }
}
