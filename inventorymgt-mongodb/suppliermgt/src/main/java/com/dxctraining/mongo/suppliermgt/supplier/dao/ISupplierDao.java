package com.dxctraining.mongo.suppliermgt.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxctraining.mongo.suppliermgt.entities.Supplier;

public interface ISupplierDao extends MongoRepository<Supplier, String> {	
	
List<Supplier> findByName(String name);
}
