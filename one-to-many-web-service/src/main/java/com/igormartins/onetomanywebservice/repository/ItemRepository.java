package com.igormartins.onetomanywebservice.repository;

import com.igormartins.onetomanywebservice.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
