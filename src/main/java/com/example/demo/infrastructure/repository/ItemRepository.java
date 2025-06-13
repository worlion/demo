package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

