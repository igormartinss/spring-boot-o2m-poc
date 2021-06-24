package com.igormartins.onetomanywebservice.controller;

import com.igormartins.onetomanywebservice.model.Item;
import com.igormartins.onetomanywebservice.model.dto.ItemDTO;
import com.igormartins.onetomanywebservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemDTO> addItem(@RequestBody final ItemDTO itemDTO) {
        Item item = itemService.addItem(Item.from(itemDTO));

        return new ResponseEntity<>(itemDTO.from(item), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getItems() {
        List<Item> items = itemService.getItems();
        List<ItemDTO> itemsDTO = items.stream().map(ItemDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(itemsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable final Long id) {
        Item item = itemService.getItem(id);

        return new ResponseEntity<>(ItemDTO.from(item), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ItemDTO> deleteItem(@PathVariable final Long id) {
        Item item = itemService.deleteItem(id);
        return new ResponseEntity<>(ItemDTO.from(item), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ItemDTO> editItem(@PathVariable final Long id, @RequestBody ItemDTO itemDTO) {
        Item item = itemService.editItem(id, Item.from(itemDTO));
        return new ResponseEntity<>(ItemDTO.from(item), HttpStatus.OK);
    }
}
