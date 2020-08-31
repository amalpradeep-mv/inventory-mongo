package com.dxctraining.computermgt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.computermgt.computer.dto.ComputerDto;
import com.dxctraining.computermgt.computer.dto.CreateComputerRequest;
import com.dxctraining.computermgt.computer.dto.SupplierDto;
import com.dxctraining.computermgt.computer.entities.Computer;
import com.dxctraining.computermgt.computer.service.IComputerService;
import com.dxctraining.computermgt.computer.util.ComputerUtil;

@RestController
@RequestMapping("/computer")
public class ComputerController {

	@Autowired
	private IComputerService compService;

	@Autowired
	private ComputerUtil compUtil;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ComputerDto add(@RequestBody CreateComputerRequest request) {
		String name = request.getName();
		int size = request.getDiskSize();
		int supplierId = request.getSupplierId();
		Computer computer = new Computer(name, size, supplierId);
		computer = compService.save(computer);
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		ComputerDto response = compUtil.computerDto(computer, supplierId, supplierDto.getName());
		return response;
	}

	@GetMapping("/get/{id}")
	public ComputerDto getComputer(@PathVariable("id") int id) {
		Computer computer = compService.findComputerById(id);
		int supplierId = computer.getSupplierId();
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		ComputerDto response = compUtil.computerDto(computer, supplierId, supplierDto.getName());
		return response;
	}

	@GetMapping
	public List<ComputerDto> fetchAll() {
		List<Computer> list = compService.allComputers();
		List<ComputerDto> response = new ArrayList<>();
		for (Computer computer : list) {
			int supplierId = computer.getSupplierId();
			SupplierDto supplierDto = fetchFromSupplierById(supplierId);
			ComputerDto computerDto = compUtil.computerDto(computer, supplierId, supplierDto.getName());
			response.add(computerDto);
		}
		return response;
	}

	@GetMapping("/supplier/{supplierId}")
	public List<ComputerDto> fetchAllComputers(@PathVariable("supplierId") int supplierId) {
		List<Computer> list = compService.allComputersBySupplier(supplierId);
		List<ComputerDto> response = new ArrayList<>();
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		for (Computer computer : list) {
			ComputerDto computerDto = compUtil.computerDto(computer, supplierId, supplierDto.getName());
			response.add(computerDto);
		}
		return response;
	}

	public SupplierDto fetchFromSupplierById(int supplierId) {
		String url = "http://localhost:8585/suppliers/get/" + supplierId;
		SupplierDto dto = restTemplate.getForObject(url, SupplierDto.class);
		return dto;
	}
}
