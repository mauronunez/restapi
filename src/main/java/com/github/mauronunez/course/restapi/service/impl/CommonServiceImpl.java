package com.github.mauronunez.course.restapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.github.mauronunez.course.restapi.service.CommonService;

@Component
public abstract class CommonServiceImpl<K,T> implements CommonService<K,T> {

	@Autowired
	PagingAndSortingRepository<T,K> repository;

	@Override
	public Iterable<T> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<T> paginate(Pageable pageable) {
		return repository.findAll(pageable);

	}

	@Override
	public T byId(K id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void create(T course) {
		repository.save(course);
	}

	@Override
	public void update(K id, T course) {
		repository.save(course);
	}

	@Override
	public void delete(K id) {
		repository.deleteById(id);

	}

}
