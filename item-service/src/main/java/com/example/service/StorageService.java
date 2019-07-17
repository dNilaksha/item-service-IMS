package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.model.StorageArea;

public interface StorageService {

	ResponseEntity<?> fetchAll();

	ResponseEntity<?> save(StorageArea storageArea);

	ResponseEntity<?> findById(Integer id);

	ResponseEntity<?> update(Integer id, StorageArea storageArea);

	ResponseEntity<?> delete(Integer id);

}
