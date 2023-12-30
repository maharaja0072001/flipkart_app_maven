package org.abc.exceptions;

import org.abc.exception.CustomException;

public class OrderNotFoundException extends CustomException {

    public OrderNotFoundException(final String message) {
        super(message);
    }
}
