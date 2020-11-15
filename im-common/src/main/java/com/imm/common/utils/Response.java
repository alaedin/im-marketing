package com.imm.common.utils;

import static com.imm.common.utils.ConstantUtils.SUCCESS_DELETE;
import static com.imm.common.utils.ConstantUtils.SUCCESS_GET;
import static com.imm.common.utils.ConstantUtils.SUCCESS_SAVE;
import static com.imm.common.utils.ConstantUtils.SUCCESS_UPDATE;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Response<T> {
	
	
	public ResponseEntity<ValuesObject<T>> get(T value, String objectName) {
		return respond(value, objectName, SUCCESS_GET, 200);
	}

	public ResponseEntity<ValuesObject<T>> get(List<T> value, String objectName) {
		return respond(value, objectName, SUCCESS_GET, 200);
	}

	public ResponseEntity<ValuesObject<T>> get(Set<T> value, String objectName) {
		return respond(value, objectName, SUCCESS_GET, 200);
	}

	public ResponseEntity<ValuesObject<T>> insert(T value, String objectName) {
		return respond(value, objectName, SUCCESS_SAVE, 201);
	}

	public ResponseEntity<ValuesObject<T>> insert(List<T> value, String objectName) {
		return respond(value, objectName, SUCCESS_SAVE, 201);
	}

	public ResponseEntity<ValuesObject<T>> insert(Set<T> value, String objectName) {
		return respond(value, objectName, SUCCESS_SAVE, 201);
	}

	public ResponseEntity<ValuesObject<T>> delete(T value, String objectName) {
		return respond(value, objectName, SUCCESS_DELETE, 200);
	}

	public ResponseEntity<ValuesObject<T>> delete(List<T> value, String objectName) {
		return respond(value, objectName, SUCCESS_DELETE, 200);
	}

	public ResponseEntity<ValuesObject<T>> delete(Set<T> value, String objectName) {
		return respond(value, objectName, SUCCESS_DELETE, 200);
	}

	public ResponseEntity<ValuesObject<T>> update(T value, String objectName) {
		return respond(value, objectName, SUCCESS_UPDATE, 200);
	}

	public ResponseEntity<ValuesObject<T>> update(List<T> value, String objectName) {
		return respond(value, objectName, SUCCESS_UPDATE, 200);
	}
	
	public ResponseEntity<ValuesObject<T>> update(Set<T> value, String objectName) {
		return respond(value, objectName, SUCCESS_UPDATE, 200);
	}

	public ResponseEntity<ValuesObject<T>>respond(T value, String objectName, String response ){
		return respond(value, objectName, response, 0);
	}
	
	public ResponseEntity<ValuesObject<T>> respond(T value, String objectName, String response, int outCode){
		ValuesObject valuesObject = ValuesObject.builder()
				.outCode(outCode)
				.message(Utils.message(response, objectName))
				.body(value)
				.build();
	return ResponseEntity.ok(valuesObject);
	}

	private ResponseEntity<ValuesObject<T>> respond(List<T> value, String objectName, String response, int outCode) {
		ValuesObject valuesObject = ValuesObject.builder()
				.outCode(outCode)
				.message(Utils.message(response, objectName))
				.body(value)
				.build();
	return ResponseEntity.ok(valuesObject);
	}
	
	private ResponseEntity<ValuesObject<T>> respond(Set<T> value, String objectName, String response, int outCode) {
		ValuesObject valuesObject = ValuesObject.builder()
				.outCode(outCode)
				.message(Utils.message(response, objectName))
				.body(value)
				.build();
	return ResponseEntity.ok(valuesObject);
	}
	

}
