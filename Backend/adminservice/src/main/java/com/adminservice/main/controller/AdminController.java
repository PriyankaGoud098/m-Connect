package com.adminservice.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.main.dto.RegistrationdDTO;
import com.adminservice.main.entity.Employee;
import com.adminservice.main.helperclasses.ResponseMsg;
import com.adminservice.main.service.AdminService;

@CrossOrigin(origins = "http://127.0.0.1:5504" , methods = {RequestMethod.POST, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	
	@PostMapping("/register")
	public ResponseEntity<ResponseMsg> registerUserAccount(@RequestBody RegistrationdDTO registrationDTO) {
		ResponseMsg body = adminService.empregister(registrationDTO);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
//	@PostMapping("/adduser")
//	public ResponseEntity<String> addUser(@RequestBody RegistrationDto user) {
//		userService.addUser(user);
//
//		return ResponseEntity.ok("Employee added Succesfully");
//	}
	@GetMapping("/getemployees")
	    public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> emp = adminService.getAllEmployees();

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@GetMapping("/getemployee/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long id) {

		Employee emp = adminService.getEmployeeById(id);

		if (emp != null) {
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(emp, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/DropBy/{id}")
	public String DropUserById(@PathVariable("id") long id){
		String data = adminService.DeleteUserById(id);
		
		return data;
	}


}
