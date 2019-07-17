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

import com.example.model.Category;
import com.example.model.Item;
import com.example.repository.ItemRepository;
import com.example.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/getItem")
	public ResponseEntity<?> fetchAll() {
		return itemService.fetchAll();
	}
	
	  @PostMapping("/postItem") 
	  public ResponseEntity<?> save(@RequestBody Item item){
	  
	  return itemService.save(item);
	  }

	@GetMapping("/getitem/{id}")
	public ResponseEntity<?> fetchById(@PathVariable Integer id) {

		return itemService.findById(id);
	}

	@PutMapping("/updateItem/{id}")
	public ResponseEntity<?> updateItem(@PathVariable Integer id, @RequestBody Item item) {

		return itemService.update(id,item);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return itemService.delete(id);

	}

}
