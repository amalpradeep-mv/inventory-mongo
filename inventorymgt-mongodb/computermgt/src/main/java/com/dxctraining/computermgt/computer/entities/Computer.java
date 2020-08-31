package com.dxctraining.computermgt.computer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="computer_details")
public class Computer {

	@Id
	@GeneratedValue
	private int id;
	
	private int diskSize;
	
	private String name;

	private int supplierId;
	
	public Computer() {
	}

	public Computer(String name, int diskSize, int supplierId) {
		this.name=name;
		this.diskSize = diskSize;
		this.supplierId=supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int hashCode() {
		return id;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		Computer that = (Computer) obj;
		return this.id== that.id;
	}
}
