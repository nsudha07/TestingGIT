package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.EmployeeDto;
import com.company.service.EmployeeService;

@RestController
@RequestMapping("/company/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService departmenService;

	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> addDept(@RequestBody EmployeeDto departmentDto)
	{
		departmentDto= departmenService.addDept(departmentDto);
		return new ResponseEntity<>(departmentDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeDto> updateDept(@RequestBody EmployeeDto departmentDto, @RequestParam("deptId") String deptId)
	{
		departmentDto= departmenService.updateDept(departmentDto, deptId);
		return new ResponseEntity<>(departmentDto, HttpStatus.CREATED); 
	}
	
	@GetMapping("/getByDept")
	public ResponseEntity<EmployeeDto> findByDeptId(@RequestParam("deptId") String deptId)
	{
		EmployeeDto departmentDto= departmenService.findByDeptId(deptId);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<?> deleteDept(@RequestParam("deptId") String deptId)
	{
		departmenService.deleteById(deptId);
		return new ResponseEntity<>(deptId, HttpStatus.OK);
	}
	
	@GetMapping("/getAllDept")
	public List<EmployeeDto> getAllDept()
	{
		return departmenService.findAll();
	}
}
