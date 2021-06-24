package com.igormartins.onetomanywebservice.model.dto;

import com.igormartins.onetomanywebservice.model.Cart;
import com.igormartins.onetomanywebservice.model.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartDTO {
    private Long id;
    private String name;
    private List<ItemDTO> itemsDTO = new ArrayList<>();

    public static CartDTO from(Cart cart){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setItemsDTO(cart.getItems().stream().map(ItemDTO::from).collect(Collectors.toList()));
        cartDTO.setName(cart.getName());

        return cartDTO;
    }
}
