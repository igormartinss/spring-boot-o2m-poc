package com.igormartins.onetomanywebservice.model;

import com.igormartins.onetomanywebservice.model.dto.ItemDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serialNumber;

    @ManyToOne
    private Cart cart;

    public static Item from(ItemDTO itemDTO) {
        Item item = new Item();
        item.setSerialNumber(itemDTO.getSerialNumber());

        return item;
    }
}
