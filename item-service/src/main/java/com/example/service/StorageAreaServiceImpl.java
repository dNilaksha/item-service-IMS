package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.model.ResposnseValue;
import com.example.model.StorageArea;
import com.example.model.StorageAreaResposnseEntity;
import com.example.model.StoreageAreaListResposnseEntity;
import com.example.repository.StorageAreaRepository;

public class StorageAreaServiceImpl implements StorageService{

	@Autowired
	StorageAreaResposnseEntity storageAreaResposnseEntity;
	
	@Autowired
	StorageAreaRepository storageAreaRepository;
	
	@Autowired
	ResposnseValue responseValue;
	
	@Autowired
	StoreageAreaListResposnseEntity storeageAreaListResposnseEntity;
	
	
	
	@Override
	public ResponseEntity<?> fetchAll() {
		List<StorageArea> store = storageAreaRepository.findAll();
		if(store == null || store.size()<=0 || store.toString().equals("[]")) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			storeageAreaListResposnseEntity.setStatus("success");
			storeageAreaListResposnseEntity.setMsg("success");
			storeageAreaListResposnseEntity.setCode("success");
			storeageAreaListResposnseEntity.setStorageAreas(store);
			return new ResponseEntity<>(storeageAreaListResposnseEntity,HttpStatus.ACCEPTED);
		}
	}

	@Override
	public ResponseEntity<?> save(StorageArea storageArea) {
		StorageArea store = storageAreaRepository.save(storageArea);
		if(store==null) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			
			storageAreaResposnseEntity.setStatus("success");
			storageAreaResposnseEntity.setMsg("success");
			storageAreaResposnseEntity.setCode("success");
			storageAreaResposnseEntity.setStorageArea(store);
			return new ResponseEntity<>(storageAreaResposnseEntity,HttpStatus.ACCEPTED);
		}
	}

	@Override
	public ResponseEntity<?> findById(Integer id) {
		boolean isExist = storageAreaRepository.existsById(id);
		if (isExist) {
			
			Optional<StorageArea> optional = storageAreaRepository.findById(id);
			storageAreaResposnseEntity.setStatus("success");
			storageAreaResposnseEntity.setMsg("success");
			storageAreaResposnseEntity.setCode("success");
			storageAreaResposnseEntity.setStorageArea(optional.get());
			return new ResponseEntity<>(storageAreaResposnseEntity,HttpStatus.ACCEPTED);
			
 	
		}else {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> update(Integer id, StorageArea storageArea) {
		Optional<StorageArea> optional =  storageAreaRepository.findById(id);
		if(optional.isPresent()) {
			responseValue.setStatus("success");
			responseValue.setMsg("success");
			responseValue.setCode("success");
			
			StorageArea store=new StorageArea();
			store.setId(id);
			store.setName(storageArea.getName());
			storageAreaRepository.save(store);
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
		Optional<StorageArea> optional =  storageAreaRepository.findById(id);
		if(optional.isPresent()) {
			
			responseValue.setStatus("Failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			storageAreaRepository.deleteById(id);
	}
		responseValue.setStatus("success");
		responseValue.setMsg("success");
		responseValue.setCode("success");
	return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
	}

}
