package com.dxctraining.phonemgt.phone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.phonemgt.exception.PhoneNotFoundException;
import com.dxctraining.phonemgt.phone.entities.Phone;

@Repository
public class PhoneDaoImpl implements IPhoneDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Phone save(Phone phone) {
		em.persist(phone);
		return phone;
	}

	@Override
	public Phone findPhoneById(int id) {
		Phone phone = em.find(Phone.class, id);
		if (phone == null) {
			throw new PhoneNotFoundException("Phone not found");
		}
		return phone;
	}

	@Override
	public Phone update(Phone phone) {
		phone = em.merge(phone);
		return phone;
	}

	@Override
	public Phone remove(int id) {
		Phone phone = findPhoneById(id);
		em.remove(phone);
		return phone;
	}

	@Override
	public List<Phone> allPhones() {
		String jpaql = "from Phone";
		TypedQuery<Phone> query = em.createQuery(jpaql, Phone.class);
		List<Phone> phoneList = query.getResultList();
		return phoneList;
	}

	@Override
	public List<Phone> allPhonesBySupplier(int supplierId) {
		String jpaql = "from Phone where supplierId=:supplier";
		TypedQuery<Phone> query = em.createQuery(jpaql, Phone.class);
		query.setParameter("supplier", supplierId);
		List<Phone> phoneList = query.getResultList();
		return phoneList;
	}
}
