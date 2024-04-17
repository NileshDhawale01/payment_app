package com.nsd.payment_app.apis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.payment_app.dtos.DepartmentsDto;
import com.nsd.payment_app.services.DepartmentsService;

@RestController
@RequestMapping("/department")
public class DepartmentsApis {

	@Autowired
	private DepartmentsService departmentsService;

	@PostMapping
	public ResponseEntity<Map<String, Object>> addDepartment(@RequestBody DepartmentsDto departmentsDto) {

		return departmentsService.addDepartment(departmentsDto);
	}
}
