package org.abc.exceptions;

import org.abc.exception.CustomException;

public class ItemRemovalFailedException extends CustomException {

    public ItemRemovalFailedException(final String message) {
        super(message);
    }
}
