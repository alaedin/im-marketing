package com.imm.utility;

import static com.imm.utility.ConstantUtils.SUCCESS_DELETE;
import static com.imm.utility.ConstantUtils.SUCCESS_GET;
import static com.imm.utility.ConstantUtils.SUCCESS_SAVE;
import static com.imm.utility.ConstantUtils.SUCCESS_UPDATE;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Service
public class Response<T> {
	
	public ResponseEntity<?> get(Object value,String objectName){
		return respond(value, objectName, SUCCESS_GET);
	}
	
	public ResponseEntity<?> insert(Object value,String objectName){
		return respond(value, objectName, SUCCESS_SAVE);
	}
	
	public ResponseEntity<?> delete(Object value,String objectName){
		return respond(value, objectName, SUCCESS_DELETE);
	}
	
	public ResponseEntity<?> update(Object value,String objectName){
			return respond(value, objectName, SUCCESS_UPDATE);
	}

	private ResponseEntity<?>respond(Object value, String objectName,String response ){
		ValuesObject<?> valuesObject = ValuesObject.builder()
				.outCode(0)
				.message(Utils.message(response, objectName))
				.body(value)
				.build();
	return ResponseEntity.ok(valuesObject);
	}
}
