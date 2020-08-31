package com.dxctraining.mongo.suppliermgt.service;

import java.util.List;

import com.dxctraining.mongo.suppliermgt.entities.Supplier;

public interface ISupplierService {

	Supplier save(Supplier supplier);

	void removeById(String id);

	List<Supplier> findByName(String name);

	Supplier findById(String id);

	List<Supplier> findAll();

}
