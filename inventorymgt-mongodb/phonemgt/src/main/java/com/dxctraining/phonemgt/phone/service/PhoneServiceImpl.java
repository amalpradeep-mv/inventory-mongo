package com.dxctraining.phonemgt.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.phonemgt.exception.InvalidArgumentException;
import com.dxctraining.phonemgt.phone.dao.IPhoneDao;
import com.dxctraining.phonemgt.phone.entities.Phone;

@Transactional
@Service
public class PhoneServiceImpl implements IPhoneService {

	@Autowired
	private IPhoneDao phoneDao;

	@Override
	public void validate(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("Argument is null");
		}
	}

	@Override
	public Phone save(Phone phone) {
		validate(phone);
		phoneDao.save(phone);
		return phone;
	}

	@Override
	public Phone findPhoneById(int id) {
		validate(id);
		Phone phone = phoneDao.findPhoneById(id);
		return phone;
	}

	@Override
	public Phone remove(int id) {
		validate(id);
		Phone phone = phoneDao.remove(id);
		return phone;
	}

	@Override
	public List<Phone> allPhones() {
		List<Phone> allphones = phoneDao.allPhones();
		return allphones;
	}

	@Override
	public Phone update(Phone phone) {
		validate(phone);
		phoneDao.update(phone);
		return phone;
	}

	@Override
	public List<Phone> allPhonesBySupplier(int supplierId) {
		List<Phone>list=phoneDao.allPhonesBySupplier(supplierId);
		return list;
	}
	
}
