package com.example.demo.infrastructure.controller;

import com.example.demo.domain.model.Item;
import com.example.demo.infrastructure.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ItemRepository repository;

    @BeforeEach
    void cleanDatabase() {
        repository.deleteAll();
    }

    @Test
    void getAll() {
        repository.save(new Item(null, "Item 1", true));
        ResponseEntity<Item[]> response = restTemplate.getForEntity("/items", Item[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);
    }

    @Test
    void getById() {
        Item saved = repository.save(new Item(null, "Item by ID", true));
        ResponseEntity<Item> response = restTemplate.getForEntity("/items/" + saved.getId(), Item.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getTitle()).isEqualTo("Item by ID");
    }

    @Test
    void create() {
        Item newItem = new Item(null, "Nuevo", true);
        ResponseEntity<Item> response = restTemplate.postForEntity("/items", newItem, Item.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getId()).isNotNull();
    }

    @Test
    void update() {
        Item existing = repository.save(new Item(null, "Original", true));
        Item updated = new Item(null, "Actualizado", false);

        HttpEntity<Item> entity = new HttpEntity<>(updated);
        ResponseEntity<Item> response = restTemplate.exchange("/items/" + existing.getId(), HttpMethod.PUT, entity, Item.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getTitle()).isEqualTo("Actualizado");
    }

    @Test
    void delete() {
        Item item = repository.save(new Item(null, "Para borrar", true));

        ResponseEntity<Void> response = restTemplate.exchange("/items/" + item.getId(), HttpMethod.DELETE, null, Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}