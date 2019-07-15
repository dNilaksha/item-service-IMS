package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Brand;
import com.example.model.Category;
import com.example.repository.CatergoryRepository;

@Service
public class CatergoryServiceImpl implements CategoryService {

	@Autowired
	CatergoryRepository categoryRepository;
	
	@Override
	public List<Category> fetchAll() {
	
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public Category findById(Integer id) {
		boolean isExist = categoryRepository.existsById(id);
		if (isExist) {
			
			Optional<Category> optional = categoryRepository.findById(id);
			return optional.get();
			
		}
		return null;
	}

	@Override
	public Category update(Integer id, Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
