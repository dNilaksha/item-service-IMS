package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.model.Uom;

public interface UomService {

	ResponseEntity<?> fetchAll();

	ResponseEntity<?> save(Uom uom);

	ResponseEntity<?> findById(Integer id);

	ResponseEntity<?> update(Integer id, Uom uom);

	ResponseEntity<?> delete(Integer id);

}
