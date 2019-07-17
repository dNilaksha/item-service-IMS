package com.example.controller;

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


import com.example.model.StorageArea;
import com.example.service.StorageService;

@RestController
@RequestMapping("/storageArea")
public class StorageAreaController {

	@Autowired
	StorageService storageService;
	
	
	@GetMapping("/getStorage")
	public ResponseEntity<?> fetchAll() {
		return storageService.fetchAll();
	}
	
	  @PostMapping("/postStorage") 
	  public ResponseEntity<?> save(@RequestBody StorageArea storageArea){
	  
	  return storageService.save(storageArea);
	  }

	@GetMapping("/getStorage/{id}")
	public ResponseEntity<?> fetchById(@PathVariable Integer id) {

		return storageService.findById(id);
	}

	@PutMapping("/updateStorage/{id}")
	public ResponseEntity<?> updateItem(@PathVariable Integer id, @RequestBody StorageArea storageArea) {

		return storageService.update(id,storageArea);
	}

	@RequestMapping(value = "/storage/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return storageService.delete(id);

	}
}
