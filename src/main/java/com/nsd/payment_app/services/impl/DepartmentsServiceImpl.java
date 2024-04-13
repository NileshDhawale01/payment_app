package com.nsd.payment_app.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsd.payment_app.dtos.DepartmentsDto;
import com.nsd.payment_app.entities.Departments;
import com.nsd.payment_app.mapper.DepartmentsMapper;
import com.nsd.payment_app.repo.DepartmentsRepo;
import com.nsd.payment_app.services.DepartmentsService;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

	@Autowired
	private DepartmentsRepo departmentsRepo;

	@Override
	public ResponseEntity<Map<String, Object>> addDepartment(DepartmentsDto departmentsDto) {

		Departments departments = DepartmentsMapper.TO_DEPARTMENTS.apply(departmentsDto).orElse(null);

		Map<String, Object> response = new HashMap<>();
		if (Objects.nonNull(departments)) {
			Departments departments2 = departmentsRepo.save(departments);
			response.put("message", "Success");
			response.put("status", 200);
			response.put("data", departments2.getDepartmentId());
		} else {
			response.put("message", "Error");
			response.put("status", 500);
			response.put("data", null);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
