package org.abc.exceptions;

import org.abc.exception.CustomException;

public class ItemUpdateFailedException extends CustomException {

    public ItemUpdateFailedException(final String message) {
        super(message);
    }
}
