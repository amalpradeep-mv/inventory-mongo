package com.dxctraining.mongo.suppliermgt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.mongo.suppliermgt.dao.*;
import com.dxctraining.mongo.suppliermgt.entities.*;
import com.dxctraining.mongo.suppliermgt.exception.SupplierNotFoundException;

@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private ISupplierDao dao;

	@Override
	public Supplier save(Supplier supplier) {
		supplier = dao.save(supplier);
		return supplier;
	}

	@Override
	public Supplier findById(String id) {
		Optional<Supplier> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new SupplierNotFoundException("supplier not found for id= " + id);
		}
		Supplier supplier = optional.get();
		return supplier;
	}

	@Override
	public void removeById(String id) {
		dao.deleteById(id);
	}

	@Override
	public List<Supplier> findByName(String name) {
		List<Supplier> list = dao.findByName(name);
		return list;
	}

	@Override
	public List<Supplier> findAll() {
		List<Supplier> supplier = dao.findAll();
		return supplier;
	}

}
