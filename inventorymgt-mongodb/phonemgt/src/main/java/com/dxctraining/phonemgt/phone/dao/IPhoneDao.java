package com.dxctraining.phonemgt.phone.dao;

import java.util.List;

import com.dxctraining.phonemgt.phone.entities.Phone;

public interface IPhoneDao {

	Phone save(Phone phone);

	Phone findPhoneById(int id);

	Phone remove(int id);

	List<Phone> allPhones();

	List<Phone> allPhonesBySupplier(int supplierId);

	Phone update(Phone phone);
}