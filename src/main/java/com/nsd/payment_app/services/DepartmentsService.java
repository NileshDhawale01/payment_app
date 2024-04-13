package com.nsd.payment_app.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.nsd.payment_app.dtos.DepartmentsDto;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */
public interface DepartmentsService {

	public ResponseEntity<Map<String, Object>> addDepartment(DepartmentsDto departmentsDto);
}
