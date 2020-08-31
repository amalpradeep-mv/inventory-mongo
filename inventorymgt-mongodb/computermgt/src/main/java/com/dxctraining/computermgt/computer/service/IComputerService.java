package com.dxctraining.computermgt.computer.service;

import java.util.List;

import com.dxctraining.computermgt.computer.entities.Computer;

public interface IComputerService {
	
	void validate(Object obj);
	
	Computer save(Computer computer);

	Computer findComputerById(int id);

	Computer remove(int id);

	List<Computer> allComputers();

	Computer update(Computer computer);

	List<Computer> allComputersBySupplier(int supplierId);

}
