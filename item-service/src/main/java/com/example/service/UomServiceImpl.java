package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.model.ResposnseValue;
import com.example.model.Uom;
import com.example.model.UomListResposnseEntity;
import com.example.model.UomResposnseEntity;
import com.example.repository.UomRepository;

public class UomServiceImpl implements UomService{

	@Autowired
	UomResposnseEntity uomResposnseEntity;
	
	@Autowired
	UomRepository uomRepository;
	
	@Autowired
	ResposnseValue responseValue;
	
	@Autowired
	UomListResposnseEntity uomListResposnseEntity;
	
	
	
	@Override
	public ResponseEntity<?> fetchAll() {
		List<Uom> uom = uomRepository.findAll();
		if(uom == null || uom.size()<=0 || uom.toString().equals("[]")) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			uomListResposnseEntity.setStatus("success");
			uomListResposnseEntity.setMsg("success");
			uomListResposnseEntity.setCode("success");
			uomListResposnseEntity.setUom(uom);
			return new ResponseEntity<>(uomListResposnseEntity,HttpStatus.ACCEPTED);
		}
	}

	@Override
	public ResponseEntity<?> save(Uom uom) {
		Uom uoms =uomRepository.save(uom);
		if(uoms==null) {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}else {
			
		uomResposnseEntity.setStatus("success");
		uomResposnseEntity.setMsg("success");
		uomResposnseEntity.setCode("success");
		uomResposnseEntity.setUom(uoms);
			return new ResponseEntity<>(uomResposnseEntity,HttpStatus.ACCEPTED);
		}
	}

	@Override
	public ResponseEntity<?> findById(Integer id) {
		boolean isExist = uomRepository.existsById(id);
		if (isExist) {
			
			Optional<Uom> optional = uomRepository.findById(id);
			uomResposnseEntity.setStatus("success");
			uomResposnseEntity.setMsg("success");
			uomResposnseEntity.setCode("success");
			uomResposnseEntity.setUom(optional.get());
			return new ResponseEntity<>(uomResposnseEntity,HttpStatus.ACCEPTED);
			
 	
		}else {
			responseValue.setStatus("failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> update(Integer id, Uom uom) {
		Optional<Uom> optional =  uomRepository.findById(id);
		if(optional.isPresent()) {
			responseValue.setStatus("success");
			responseValue.setMsg("success");
			responseValue.setCode("success");
			
			Uom uofm=new Uom();
			uofm.setId(id);
			uofm.setUnit(uom.getUnit());
			uomRepository.save(uofm);
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
		Optional<Uom> optional =   uomRepository.findById(id);
		if(optional.isPresent()) {
			
			responseValue.setStatus("Failed");
			responseValue.setMsg("Failed");
			responseValue.setCode("fail");
			uomRepository.deleteById(id);
	}
		responseValue.setStatus("success");
		responseValue.setMsg("success");
		responseValue.setCode("success");
	return new ResponseEntity<>(responseValue,HttpStatus.BAD_REQUEST);
	}
	}


