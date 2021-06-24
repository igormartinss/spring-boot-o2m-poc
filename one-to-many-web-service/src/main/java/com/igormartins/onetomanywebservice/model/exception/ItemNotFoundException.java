package com.igormartins.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(final Long id) {
        super(MessageFormat.format("Não achou o item com id: {0}", id));
    }
}
