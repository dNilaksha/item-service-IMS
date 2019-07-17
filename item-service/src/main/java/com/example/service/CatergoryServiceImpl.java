package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.model.Category;
import com.example.model.CategoryListResposnseEntity;
import com.example.model.CategoryResposnseEntity;
import com.example.model.ResposnseValue;
import com.example.repository.CatergoryRepository;

@Service
public class CatergoryServiceImpl implements CategoryService {

	@Autowired
	CatergoryRepository categoryRepository;
	
	@Autowired
	ResposnseValue responseValue;
	
	@Autowired
	CategoryListResposnseEntity categoryListResposnseEntity;
	
	@Autowired
	CategoryResposnseEntity categoryResposnseEntity;

	@Override
	public ResponseEntity<?> fetchAll() {
		List<Category> category = categoryRepository.findAll();
		if(category == null || category.size()<=0 || category.toString().equals("[]")) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			categoryListResposnseEntity.setStatus("success");
			categoryListResposnseEntity.setMsg("success");
			categoryListResposnseEntity.setCode("success");
			categoryListResposnseEntity.setCategories(category);
			return new ResponseEntity<>(categoryListResposnseEntity,HttpStatus.ACCEPTED);
		}
	}

	@Override
	public ResponseEntity<?> save(Category category) {

		Category categories = categoryRepository.save(category);
		if(categories==null) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			
			categoryResposnseEntity.setStatus("success");
			categoryResposnseEntity.setMsg("success");
			categoryResposnseEntity.setCode("success");
			categoryResposnseEntity.setCategory(categories);
			return new ResponseEntity<>(categoryResposnseEntity,HttpStatus.ACCEPTED);
		}
	}

	@Override
	public ResponseEntity<?> findById(Integer id) {
		boolean isExist = categoryRepository.existsById(id);
		if (isExist) {
			
			Optional<Category> optional = categoryRepository.findById(id);
			categoryResposnseEntity.setStatus("success");
			categoryResposnseEntity.setMsg("success");
			categoryResposnseEntity.setCode("success");
			categoryResposnseEntity.setCategory(optional.get());
			return new ResponseEntity<>(categoryResposnseEntity,HttpStatus.ACCEPTED);
			
 	
		}else {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> update(Integer id, Category category) {
		Optional<Category> optional =  categoryRepository.findById(id);
		if(optional.isPresent()) {
			responseValue.setStatus("success");
			responseValue.setMsg("success");
			responseValue.setCode("success");
			
			Category categories=new Category();
			categories.setId(id);
			categories.setName(category.getName());
			categories.setCriticalLevel(category.getCriticalLevel());
			categories.setMaxLevel(category.getMaxLevel());
			categories.setReOrderLevel(category.getReOrderLevel());
			categoryRepository.save(categories);
			return new ResponseEntity<>(responseValue,HttpStatus.ACCEPTED);
		}else {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		Optional<Category> optional =  categoryRepository.findById(id);
		if(optional.isPresent()) {
			
			responseValue.setStatus("Failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			categoryRepository.deleteById(id);
	}
		responseValue.setStatus("success");
		responseValue.setMsg("success");
		responseValue.setCode("success");
	return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
	}
	


}
