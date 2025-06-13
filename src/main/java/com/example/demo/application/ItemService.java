package com.example.demo.application;

import com.example.demo.domain.model.Item;
import com.example.demo.infrastructure.exception.ItemNotFoundException;
import com.example.demo.infrastructure.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for handling business logic related to Items.
 * Acts as an intermediary between the controller and the repository.
 *
 * @author Imanol Conde
 * @since June 2025
 */

@Service
public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> listAll() {
        return repository.findAll();
    }

    public Item getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found with id " + id));
    }

    public Item save(Item item) {
        return repository.save(item);
    }

    public Item update(Long id, Item updatedItem) {
        Item existing = repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found with id " + id));

        existing.setTitle(updatedItem.getTitle());
        existing.setActive(updatedItem.isActive());

        return repository.save(existing);
    }

    public void delete(Long id) {
        Item existing = repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found with id " + id));

        repository.delete(existing);
    }
}

