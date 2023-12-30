package org.abc.exceptions;

import org.abc.exception.CustomException;

public class ItemAdditionFailedException extends CustomException {

    public ItemAdditionFailedException(final String message) {
        super(message);
    }
}
