package com.nsd.payment_app.apis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/test/{Id}")
	public ResponseEntity<Map<String, Object>> test(@PathVariable Integer Id) {

		Map<String, Object> map = new HashMap<>();
		map.put("Name", "Nilesh Dhawale");
		map.put("Education", "B Tech");
		map.put("Birth Date", "25 March 2000");
		map.put("Hpbby", "Science");
		map.put("Id", Id);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Map<String, Object>> testing(@PathVariable Integer id,
			@RequestBody Map<String, Object> data) {

		Map<String, Object> map = new HashMap<>();
		map.put("ID", id);
		map.put("Map", data);
		return new ResponseEntity(map, HttpStatusCode.valueOf(200));
	}
}
