package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.model.Item;
import com.example.model.ItemListResposnseEntity;
import com.example.model.ItemResposnseEntity;
import com.example.model.ResposnseValue;
import com.example.repository.ItemRepository;

public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemResposnseEntity itemResponseEntity;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ResposnseValue responseValue;
	
	@Autowired
	ItemListResposnseEntity itemListResponseEntity;
	
	
	@Override
	public ResponseEntity<?> fetchAll() {
		List<Item> items = itemRepository.findAll();
		if(items == null || items.size()<=0 || items.toString().equals("[]")) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			itemListResponseEntity.setStatus("success");
			itemListResponseEntity.setMsg("success");
			itemListResponseEntity.setCode("success");
			itemListResponseEntity.setItem(items);
			return new ResponseEntity<>(itemListResponseEntity,HttpStatus.ACCEPTED);
		}
	}

	

	@Override
	public ResponseEntity<?> findById(Integer id) {
		boolean isExist = itemRepository.existsById(id);
		if (isExist) {
			
			Optional<Item> optional = itemRepository.findById(id);
			itemResponseEntity.setStatus("success");
			itemResponseEntity.setMsg("success");
			itemResponseEntity.setCode("success");
			itemResponseEntity.setItem(optional.get());
			return new ResponseEntity<>(itemResponseEntity,HttpStatus.ACCEPTED);
			
 	
		}else {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}
			
	}



	@Override
	public ResponseEntity<?> delete(Integer id) {
		Optional<Item> optional =  itemRepository.findById(id);
		if(optional.isPresent()) {
			
			responseValue.setStatus("Failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			itemRepository.deleteById(id);
	}
		responseValue.setStatus("success");
		responseValue.setMsg("success");
		responseValue.setCode("success");
	return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> save(Item item) {
		Item items = itemRepository.save(item);
		if(items==null) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			
			itemResponseEntity.setStatus("success");
			itemResponseEntity.setMsg("success");
			itemResponseEntity.setCode("success");
			itemResponseEntity.setItem(items);
			return new ResponseEntity<>(itemResponseEntity,HttpStatus.ACCEPTED);
		}
	}



	@Override
	public ResponseEntity<?> update(Integer id, Item item) {
		Optional<Item> optional =  itemRepository.findById(id);
		if(optional.isPresent()) {
			responseValue.setStatus("success");
			responseValue.setMsg("success");
			responseValue.setCode("success");
			
			Item items=new Item();
			items.setId(id);
			items.setItemCode(item.getItemCode());
			items.setBrand(item.getBrand());
			items.setCategory(item.getCategory());
			items.setUom(item.getUom());
			items.setStorageArea(item.getStorageArea());
			items.setUserId(item.getUserId());
			items.setCreateDate(item.getCreateDate());
			itemRepository.save(items);
			return new ResponseEntity<>(responseValue,HttpStatus.ACCEPTED);
		}else {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}
	}



}
