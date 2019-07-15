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
	public ResponseEntity<List<Category>> fetchAll() {
		return ResponseEntity.ok(categoryService.fetchAll());
	}
	@PostMapping("/postCategory")
	public ResponseEntity<Category> save(@RequestBody Category category){
		
		return ResponseEntity.ok(categoryService.save(category));
	}

	@GetMapping("/getCategory/{id}")
	public ResponseEntity<Category> fetchById(@PathVariable Integer id){

		return ResponseEntity.ok(categoryService.findById(id));
	}
	@PutMapping("/updateCategory/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Integer id,@RequestBody Category category){
		
		return ResponseEntity.ok(categoryService.update(id,category));
	}


	@RequestMapping(value = "/category/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Category> delete(@PathVariable Integer id){
		return ResponseEntity.ok(categoryService.delete(id));
	  
	  }	
}
