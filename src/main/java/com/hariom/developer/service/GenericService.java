package com.hariom.developer.service;

import java.util.Collection;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 * @param <T>
 */
public interface GenericService<T> {

	Collection<T> getAll();

	T getById(int id);

	void removeById(int id);

	void insert(T newObj);
	
	void update(T oldObj);
}