package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Category;

public interface CatergoryRepository extends JpaRepository<Category, Integer>{

}
