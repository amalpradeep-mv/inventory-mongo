package com.dxctraining.phonemgt.phone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone_details")
public class Phone {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private int storageSize;

	private int supplierId;

	public Phone() {
	}

	public Phone(String name, int storageSize, int supplierId) {
		this.name = name;
		this.storageSize = storageSize;
		this.supplierId = supplierId;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Phone that = (Phone) obj;
		return this.id == that.id;

	}

}
