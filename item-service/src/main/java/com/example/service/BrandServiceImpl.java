package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Brand;
import com.example.model.BrandListResposnseEntity;
import com.example.model.BrandResposnseEntity;
import com.example.model.ResposnseValue;
import com.example.repository.BrandRepository;
@Service

public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandResposnseEntity brandResponseEntity;
	
	@Autowired
	BrandRepository brandRepository;
	
	@Autowired
	ResposnseValue responseValue;
	
	@Autowired
	BrandListResposnseEntity brandListResposnseEntity;
	
	@Override
	public ResponseEntity<?> fetchAll() {
		
		List<Brand> brands = brandRepository.findAll();
		if(brands == null || brands.size()<=0 || brands.toString().equals("[]")) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			brandListResposnseEntity.setStatus("success");
			brandListResposnseEntity.setMsg("success");
			brandListResposnseEntity.setCode("success");
			brandListResposnseEntity.setBrand(brands);
			return new ResponseEntity<>(brandListResposnseEntity,HttpStatus.ACCEPTED);
		}
	
	}


	@Override
	public ResponseEntity<?> save(Brand brand) {
		
		Brand brand2 = brandRepository.save(brand);
		if(brand2==null) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			
			brandResponseEntity.setStatus("success");
			brandResponseEntity.setMsg("success");
			brandResponseEntity.setCode("success");
			brandResponseEntity.setBrand(brand2);
			return new ResponseEntity<>(brandResponseEntity,HttpStatus.ACCEPTED);
		}
	}


	@Override
	public ResponseEntity<?> findById(Integer id) {
		
		boolean isExist = brandRepository.existsById(id);
		if (isExist) {
			
			Optional<Brand> optional = brandRepository.findById(id);
			brandResponseEntity.setStatus("success");
			brandResponseEntity.setMsg("success");
			brandResponseEntity.setCode("success");
			brandResponseEntity.setBrand(optional.get());
			return new ResponseEntity<>(brandResponseEntity,HttpStatus.ACCEPTED);
			//return new ResponseEntity<>(brandResponseEntity,HttpStatus.BAD_REQUEST);
 	
		}else {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}
			
	//return null;
	}


	@Override
	public ResponseEntity<?> update(Integer id, Brand brand) {
		Optional<Brand> optional =  brandRepository.findById(id);
		if(optional.isPresent()) {
			responseValue.setStatus("success");
			responseValue.setMsg("success");
			responseValue.setCode("success");
			
			Brand brand2=new Brand();
			brand2.setId(id);
			brand2.setName(brand.getName());
			brandRepository.save(brand2);
			return new ResponseEntity<>(responseValue,HttpStatus.ACCEPTED);
		}else {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}
		
				
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		Optional<Brand> optional =  brandRepository.findById(id);
		if(optional.isPresent()) {
			
			responseValue.setStatus("Failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			brandRepository.deleteById(id);
	}
		responseValue.setStatus("success");
		responseValue.setMsg("success");
		responseValue.setCode("success");
	return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
	}

	

}
