package org.abc.exceptions;

import org.abc.exception.CustomException;

public class OrderRemovalFailedException extends CustomException {

    public OrderRemovalFailedException(final String message) {
        super(message);
    }
}
