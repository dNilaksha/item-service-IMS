package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Brand;

public interface BrandService {
	//Brand findById();

	ResponseEntity<?> fetchAll();

	ResponseEntity<?> save(Brand brand);

	Brand findById(Integer id);

	Brand update(Integer id, Brand brand);

	Brand delete(Integer id);
}
