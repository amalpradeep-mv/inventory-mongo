package com.dxctraining.computermgt.computer.dao;

import java.util.List;

import com.dxctraining.computermgt.computer.entities.Computer;

public interface IComputerDao {
	
	Computer save(Computer computer);

	Computer findComputerById(int id);

	Computer remove(int id);

	List<Computer> allComputers();

	Computer update(Computer computer);

	List<Computer> allComputersBySupplier(int supplierId);
}
