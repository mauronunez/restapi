package com.github.mauronunez.course.restapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonService<K,T> {

	Iterable<T> getAll() ;

	Page<T> paginate(Pageable pageable);

	T byId(K id);

	void create(T course);

	void update(K id, T course);

	void delete(K id);


}
