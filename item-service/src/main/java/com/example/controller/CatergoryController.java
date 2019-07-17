package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Brand;
import com.example.model.Category;
import com.example.service.CategoryService;


@RestController
@RequestMapping("/category")
public class CatergoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/getCategory")
	public ResponseEntity<?> fetchAll() {
		return categoryService.fetchAll();
	}
	@PostMapping("/postCategory")
	public ResponseEntity<?> save(@RequestBody Category category){
		
		return categoryService.save(category);
	}

	@GetMapping("/getCategory/{id}")
	public ResponseEntity<?> fetchById(@PathVariable Integer id){

		return categoryService.findById(id);
	}
	@PutMapping("/updateCategory/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Integer id,@RequestBody Category category){
		
		return categoryService.update(id,category);
	}


	@RequestMapping(value = "/category/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		return categoryService.delete(id);
	  
	  }	
}
