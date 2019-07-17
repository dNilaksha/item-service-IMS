package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Brand;

public interface BrandService {
	//Brand findById();

	ResponseEntity<?> fetchAll();

	ResponseEntity<?> save(Brand brand);

	ResponseEntity<?> findById(Integer id);

	ResponseEntity<?> update(Integer id, Brand brand);

	ResponseEntity<?> delete(Integer id);
}
