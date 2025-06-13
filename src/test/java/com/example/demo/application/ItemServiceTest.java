package com.example.demo.application;

import com.example.demo.domain.model.Item;
import com.example.demo.infrastructure.exception.ItemNotFoundException;
import com.example.demo.infrastructure.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    private ItemRepository repository;
    private ItemService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(ItemRepository.class);
        service = new ItemService(repository);
    }

    @Test
    void listAll() {
        when(repository.findAll()).thenReturn(List.of(new Item(1L,"Mocked item", true)));

        List<Item> items = service.listAll();

        assertThat(items).hasSize(1);
        verify(repository).findAll();
    }

    @Test
    void getById() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ItemNotFoundException.class, () -> service.getById(99L));
    }

    @Test
    void update() {
        Item existing = new Item(99L,"Old", true);
        Item updated = new Item(99L, "New", false);

        when(repository.findById(99L)).thenReturn(Optional.of(existing));
        when(repository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        Item result = service.update(99L, updated);

        assertThat(result.getTitle()).isEqualTo("New");
        assertThat(result.isActive()).isFalse();
    }
}