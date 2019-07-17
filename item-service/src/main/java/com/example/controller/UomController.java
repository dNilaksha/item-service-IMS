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
import com.example.model.Uom;
import com.example.service.UomService;

@RestController
@RequestMapping("/uom")
public class UomController {

	@Autowired
	UomService uomService;
	
	
	@GetMapping("/getUom")
	public ResponseEntity<?> fetchAll() {
		return uomService.fetchAll();
	}
	@PostMapping("/postUom")
	public ResponseEntity<?> save(@RequestBody Uom uom){
		
		return uomService.save(uom);
	}

	@GetMapping("/getuom/{id}")
	public ResponseEntity<?> fetchById(@PathVariable Integer id){

		return uomService.findById(id);
	}
	@PutMapping("/updateUom/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Integer id,@RequestBody Uom uom){
		
		return uomService.update(id,uom);
	}


	@RequestMapping(value = "/Uom/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		return uomService.delete(id);
	  
	  }	
}
