package com.github.mauronunez.course.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.github.mauronunez.course.restapi.service.CommonService;

public class CommonController<K,T> {
	
	@Autowired CommonService<K,T> commonService;
	
	@GetMapping public Iterable<T> paginate(Pageable page) {
		return commonService.paginate(page);
	}
	
	@GetMapping("/all") public Iterable<T> all() {
		return commonService.getAll();
	}

	@GetMapping("/{id}") public T byId(@PathVariable("id") K id) {
		T instance= commonService.byId(id);
		if(instance==null) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Instance Not Found");
		}
		return instance;
	}
	
	@PostMapping public ResponseEntity<Void> create(@RequestBody T course) {
		commonService.create(course);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}") public void update(@PathVariable("id") K id, @RequestBody T course) {
		T instance= commonService.byId(id);
		if(instance==null) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Instance Not Found");
		}
		commonService.update(id, course);
	}

	@DeleteMapping("/{id}") public void delete(@PathVariable("id") K id) {
		T instance= commonService.byId(id);
		if(instance==null) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Instance Not Found");
		}
		commonService.delete(id);
	}
	
}
