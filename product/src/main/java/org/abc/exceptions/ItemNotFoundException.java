package org.abc.exceptions;

import org.abc.exception.CustomException;

public class ItemNotFoundException extends CustomException {

    public ItemNotFoundException(final String message) {
        super(message);
    }
}
