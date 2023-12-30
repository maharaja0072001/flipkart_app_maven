package org.abc.exceptions;

import org.abc.exception.CustomException;

public class OrderAdditionFailedException extends CustomException {

    public OrderAdditionFailedException(final String message) {
        super(message);
    }
}
