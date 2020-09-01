package com.dxctraining.mongo.suppliermgt.util;

import org.springframework.stereotype.Component;

import com.dxctraining.mongo.suppliermgt.dto.SupplierDto;
import com.dxctraining.mongo.suppliermgt.entities.Supplier;

@Component
public class SupplierUtil {

	public SupplierDto supplierDto(Supplier supplier) {
		SupplierDto dto = new SupplierDto(supplier.getId(), supplier.getName(), supplier.getPassword());
		return dto;
	}
}
