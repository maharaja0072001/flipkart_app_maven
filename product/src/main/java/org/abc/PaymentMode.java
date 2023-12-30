package org.abc;

/**
 * <p>
 * Provides the payment modes.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public enum PaymentMode {

    CASH_ON_DELIVERY(1), CREDIT_OR_DEBIT_CARD(2), NET_BANKING(3), UPI(4);

    final int id;

    /**
     * <p>
     * Constructor of the enum.
     * </p>
     *
     * @param id Refers the id of the enum values
     */
    PaymentMode(final int id) {
        this.id = id;
    }

}
