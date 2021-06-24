package com.igormartins.onetomanywebservice.model;

import com.igormartins.onetomanywebservice.model.dto.CartDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public static Cart from(CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setName(cartDTO.getName());

        return cart;
    }
}
