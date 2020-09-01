package com.dxctraining.mongo.suppliermgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dxctraining.mongo.suppliermgt.entities.Supplier;

@Service
public class SupplierServiceImplDatabase implements ISupplierService {

	@Autowired
	private MongoTemplate mongo;

	@Override
	public Supplier save(Supplier supplier) {
		supplier = mongo.save(supplier);
		return supplier;
	}

	@Override
	public void removeById(String id) {
		Supplier supplier = findById(id);
		mongo.remove(supplier);
	}

	@Override
	public List<Supplier> findByName(String name) {
		Criteria criteria = Criteria.where("name").is(name);
		Query query = Query.query(criteria);
		List<Supplier> list = mongo.find(query, Supplier.class);
		return list;
	}

	@Override
	public Supplier findById(String id) {
		Supplier supplier = mongo.findById(id, Supplier.class);
		return supplier;
	}

	@Override
	public List<Supplier> findAll() {
		List<Supplier> list = mongo.findAll(Supplier.class);
		return list;
	}

}
