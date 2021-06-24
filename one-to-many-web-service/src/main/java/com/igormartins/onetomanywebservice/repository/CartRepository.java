package com.igormartins.onetomanywebservice.repository;

import com.igormartins.onetomanywebservice.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
