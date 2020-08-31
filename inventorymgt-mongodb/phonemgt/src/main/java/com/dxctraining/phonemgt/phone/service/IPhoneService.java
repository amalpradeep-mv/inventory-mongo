package com.dxctraining.phonemgt.phone.service;

import java.util.List;

import com.dxctraining.phonemgt.phone.entities.Phone;


public interface IPhoneService {
	
	void validate(Object arg);
	
	Phone save(Phone phone);
	
	Phone findPhoneById(int id);

	Phone remove(int id);

	Phone update(Phone phone);
	
	List<Phone> allPhones();
	
	List<Phone> allPhonesBySupplier(int supplierId);
}
