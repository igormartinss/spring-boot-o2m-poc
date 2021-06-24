package com.igormartins.onetomanywebservice.model.dto;

import com.igormartins.onetomanywebservice.model.Item;
import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String serialNumber;

    public static ItemDTO from(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setSerialNumber(item.getSerialNumber());

        return itemDTO;
    }
}
