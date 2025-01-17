package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Category;

public interface CategoryService {

	ResponseEntity<?> fetchAll();

	ResponseEntity<?> save(Category category);

	ResponseEntity<?> findById(Integer id);

	ResponseEntity<?> update(Integer id, Category category);

	ResponseEntity<?> delete(Integer id);
}
