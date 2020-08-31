package com.dxctraining.phonemgt.phone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.dxctraining.phonemgt.phone.dto.CreatePhoneRequest;
import com.dxctraining.phonemgt.phone.dto.PhoneDto;
import com.dxctraining.phonemgt.phone.dto.SupplierDto;
import com.dxctraining.phonemgt.phone.entities.Phone;
import com.dxctraining.phonemgt.phone.service.IPhoneService;
import com.dxctraining.phonemgt.phone.util.PhoneUtil;

@RestController
@RequestMapping("/phone")
public class PhoneController {

	@Autowired
	private IPhoneService phoneService;

	@Autowired
	private PhoneUtil phoneUtil;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public PhoneDto add(@RequestBody CreatePhoneRequest request) {
		String name = request.getName();
		int size = request.getStorageSize();
		int supplierId = request.getSupplierId();
		Phone phone = new Phone(name, size, supplierId);
		phone = phoneService.save(phone);
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		PhoneDto response = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
		return response;
	}

	@GetMapping("/get/{id}")
	public PhoneDto getPhone(@PathVariable("id") int id) {
		Phone phone = phoneService.findPhoneById(id);
		int supplierId = phone.getSupplierId();
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		PhoneDto response = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
		return response;
	}

	@GetMapping
	public List<PhoneDto> fetchAll() {
		List<Phone> list = phoneService.allPhones();
		List<PhoneDto> response = new ArrayList<>();
		for (Phone phone : list) {
			int supplierId = phone.getSupplierId();
			SupplierDto supplierDto = fetchFromSupplierById(supplierId);
			PhoneDto phoneDto = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
			response.add(phoneDto);
		}
		return response;
	}

	@GetMapping("/supplier/{supplierId}")
	public List<PhoneDto> fetchAllSuppliers(@PathVariable("supplierId") int supplierId) {
		List<Phone> list = phoneService.allPhonesBySupplier(supplierId);
		List<PhoneDto> response = new ArrayList<>();
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		for (Phone phone : list) {
			PhoneDto phoneDto = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
			response.add(phoneDto);
		}
		return response;
	}

	public SupplierDto fetchFromSupplierById(int supplierId) {
		String url = "http://localhost:8585/suppliers/get/" + supplierId;
		SupplierDto dto = restTemplate.getForObject(url, SupplierDto.class);
		return dto;
	}
}