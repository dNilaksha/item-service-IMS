package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.model.Category;
import com.example.model.Item;

public interface ItemService {

	ResponseEntity<?> fetchAll();

	ResponseEntity<?> save(Item item);

	ResponseEntity<?> findById(Integer id);

	ResponseEntity<?> update(Integer id, Item item);

	ResponseEntity<?> delete(Integer id);
	
}
