package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Brand;
import com.example.model.BrandResposnseEntity;
import com.example.repository.BrandRepository;
@Service

public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandResposnseEntity brandResponseEntity;
	
	@Autowired
	BrandRepository brandRepository;
	
	
	@Override
	public ResponseEntity<?> fetchAll() {
		
		List<Brand> brands = brandRepository.findAll();
		if(brands == null || brands.size()<=0 || brands.toString().equals("[]")) {
			brandResponseEntity.setStatus("failed");
			return new ResponseEntity<>(brandResponseEntity,HttpStatus.BAD_REQUEST);
		}else {
			brandResponseEntity.setStatus("success");
			
			return new ResponseEntity<>(brandResponseEntity,HttpStatus.ACCEPTED);
		}
	
	}


	@Override
	public ResponseEntity<?> save(Brand brand) {
		
		Brand brand2 = brandRepository.save(brand);
		if(brand2==null) {
			brandResponseEntity.setStatus("failed");
			return new ResponseEntity<>(brandResponseEntity,HttpStatus.BAD_REQUEST);
		}else {
			
			brandResponseEntity.setStatus("success");
			return new ResponseEntity<>(brandResponseEntity,HttpStatus.BAD_REQUEST);
		}
	}


	@Override
	public Brand findById(Integer id) {
		boolean isExist = brandRepository.existsById(id);
		if (isExist) {
			
			Optional<Brand> optional = brandRepository.findById(id);
			return optional.get();
			
		}
			
	return null;
	}


	@Override
	public Brand update(Integer id, Brand brand) {
		Optional<Brand> optional =  brandRepository.findById(id);
		if(optional.isPresent()) {
			Brand brand2=new Brand();
			brand2.setId(id);
			brand2.setName(brand.getName());
			return brandRepository.save(brand2);
		}else {
			
			return null;
		}
		
				
	}

	@Override
	public Brand delete(Integer id) {
		Optional<Brand> optional =  brandRepository.findById(id);
		if(optional.isPresent()) {
			brandRepository.deleteById(id);
	}
		return null;
	}

	

}
