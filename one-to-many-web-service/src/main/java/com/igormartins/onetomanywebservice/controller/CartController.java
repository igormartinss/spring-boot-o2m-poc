package com.igormartins.onetomanywebservice.controller;

import com.igormartins.onetomanywebservice.model.Cart;
import com.igormartins.onetomanywebservice.model.dto.CartDTO;
import com.igormartins.onetomanywebservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<CartDTO> addCart(@RequestBody final CartDTO cartDTO) {
        Cart cart = cartService.addCart(Cart.from(cartDTO));
        return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartDTO>> getCarts() {
        List<Cart> carts = cartService.getCarts();
        List<CartDTO> cartsDTO = carts.stream().map(CartDTO::from).collect(Collectors.toList());

        return new ResponseEntity<>(cartsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CartDTO> getCart(@PathVariable final Long id) {
        Cart cart = cartService.getCart(id);

        return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CartDTO> deleteCart(@PathVariable final Long id) {
        Cart cart = cartService.deleteCart(id);

        return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CartDTO> editCart(@PathVariable final Long id, final CartDTO cartDTO) {
        Cart editedCart = cartService.editCart(id, Cart.from(cartDTO));

        return new ResponseEntity<>(CartDTO.from(editedCart), HttpStatus.OK);
    }

    @PostMapping("{cartId}/items/{itemId}/add")
    public ResponseEntity<CartDTO> addItemToCart(@PathVariable final Long cartId, @PathVariable final Long itemId) {
        Cart cart = cartService.addItemToCart(cartId, itemId);
        return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
    }

    @DeleteMapping("{cartId}/items/{itemId}/remove")
    public ResponseEntity<CartDTO> removeItemFromCart(@PathVariable final Long cartId, @PathVariable final Long itemId) {
        Cart cart = cartService.removeItemFromCart(cartId, itemId);
        return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
    }

}
