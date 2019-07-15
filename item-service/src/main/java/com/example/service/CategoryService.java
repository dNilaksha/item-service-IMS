package com.example.service;

import java.util.List;

import com.example.model.Category;

public interface CategoryService {

	List<Category> fetchAll();

	Category save(Category category);

	Category findById(Integer id);

	Category update(Integer id, Category category);

	Category delete(Integer id);
}
