package com.example.demo.infrastructure.controller;

import com.example.demo.application.ItemService;
import com.example.demo.domain.model.Item;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing Item resources.
 * Provides endpoints for creating, retrieving, updating and deleting items.
 *
 * @author Imanol Conde
 * @since June 2025
 */
@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping
    public List<Item> getAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable Long id) {
        Item item = service.getById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Item> create(@Valid @RequestBody Item item) {
        Item saved = service.save(item);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @Valid @RequestBody Item item) {
        Item updated = service.update(id, item);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
