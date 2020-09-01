package com.dxctraining.mongo.suppliermgt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dxctraining.mongo.suppliermgt.entities.Supplier;
import com.dxctraining.mongo.suppliermgt.exception.SupplierNotFoundException;
import com.dxctraining.mongo.suppliermgt.service.ISupplierService;
import com.dxctraining.mongo.suppliermgt.service.SupplierServiceImpl;

@DataMongoTest
@Import(SupplierServiceImpl.class)
public class SupplierServiceImplTest {
	
	@Autowired
	private ISupplierService service;
	
	@Autowired
	private MongoTemplate mongo;

	@Test
	public void testSave_1() {
		String name="kalam";
		String password="qwerty";
		Supplier supplier=new Supplier(name,password);
		supplier=service.save(supplier);
		String id=supplier.getId();
		Supplier fetchedSupplier=mongo.findById(id, Supplier.class);
		Assertions.assertEquals(supplier.getId(), fetchedSupplier.getId());
		Assertions.assertEquals(name,supplier.getName());
		Assertions.assertEquals(password,supplier.getPassword());
	}
	
	@Test
	public void testFindById_1() {
		Executable executable=()->service.findById("123");
		Assertions.assertThrows(SupplierNotFoundException.class, executable);
	}
}
