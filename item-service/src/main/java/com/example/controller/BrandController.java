package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Brand;
import com.example.service.BrandService;


@RestController
@RequestMapping("/brand")

public class BrandController {

@Autowired
BrandService brandService;

@GetMapping("/getBrand")
public ResponseEntity<?> fetchAll() {
	return brandService.fetchAll();
}
@PostMapping("/postBrand")
public ResponseEntity<?> save(@RequestBody Brand brand){
	
	return brandService.save(brand);
}

@GetMapping("/getbrand/{id}")
public ResponseEntity<Brand> fetchById(@PathVariable Integer id){

	return ResponseEntity.ok(brandService.findById(id));
}
@PutMapping("/updateBrand/{id}")
public ResponseEntity<Brand> updateBrand(@PathVariable Integer id,@RequestBody Brand brand){
	
	return ResponseEntity.ok(brandService.update(id,brand));
}


@RequestMapping(value = "/brand/{id}",method = RequestMethod.DELETE)
public ResponseEntity<Brand> delete(@PathVariable Integer id){
	return ResponseEntity.ok(brandService.delete(id));
  
  }
  }
 