package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.StorageArea;

public interface StorageAreaRepository extends JpaRepository<StorageArea, Integer> {

}
