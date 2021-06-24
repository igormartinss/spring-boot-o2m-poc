package com.igormartins.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class CartNotFoundExcpetion extends RuntimeException{
    public CartNotFoundExcpetion(final Long id) {
        super(MessageFormat.format("Não achou o carrinho com id: {0}", id));
    }
}
