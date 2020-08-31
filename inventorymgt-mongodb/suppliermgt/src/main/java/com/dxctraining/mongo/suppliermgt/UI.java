package com.dxctraining.mongo.suppliermgt;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.mongo.suppliermgt.entities.Supplier;
import com.dxctraining.mongo.suppliermgt.service.ISupplierService;

@Component
public class UI {

	@Autowired
	private ISupplierService service;

	@PostConstruct
	public void start() {
		Supplier supplier1 = new Supplier("John", "qwerty");
		supplier1 = createSupplier(supplier1);
		String id1 = supplier1.getId();
		displaySupplierById(id1);

		Supplier supplier2 = new Supplier("Raj", "qwerty");
		supplier2 = createSupplier(supplier2);
		String id2 = supplier2.getId();
		displaySupplierById(id2);

	}

	public void displayAll() {
		List<Supplier> list = service.findAll();
		for (Supplier supplier : list) {
			displaySupplier(supplier);
		}
	}

	public Supplier createSupplier(Supplier supplier) {
		supplier = service.save(supplier);
		displaySupplier(supplier);
		return supplier;

	}

	public void displaySupplier(Supplier supplier) {
		System.out.println(supplier.getId() + " Name= " + supplier.getName() + " Password= " + supplier.getPassword());
	}

	public void displaySupplierById(String id) {
		Supplier supplier = service.findById(id);
		displaySupplier(supplier);
	}
}
