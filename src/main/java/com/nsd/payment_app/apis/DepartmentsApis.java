package com.nsd.payment_app.apis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 5d0459d0bbc25f5aa36159ea518aaeda0094d661
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
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
