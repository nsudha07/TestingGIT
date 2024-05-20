package com.company.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.EmployeeDto;
import com.company.entity.Employee;
import com.company.mapper.EmployeeMapper;
import com.company.repository.employeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	employeeRepository deptRepo;
	
	public EmployeeDto addDept(EmployeeDto departmentDto)
	{
		Employee department = EmployeeMapper.mapToDepartment(departmentDto);
		department=deptRepo.save(department);
		return EmployeeMapper.mapToDepartmentDto(department);
	}
	
	public EmployeeDto updateDept(EmployeeDto departmentDto, String deptId)
	{
		Optional<Employee> deptById = deptRepo.findById(deptId);
		if(deptById.isPresent())
		{
			Employee  dept = deptById.get();
			dept.setEmpId(departmentDto.getEmpId());
			dept.setEmpName(departmentDto.getEmpName());
			dept.setCreatedBy(departmentDto.getCreatedBy());
			dept.setCreatedOn(departmentDto.getCreatedOn());
			dept.setModifiedBy(departmentDto.getModifiedBy());
			dept.setModifiedOn(departmentDto.getModifiedOn());
			dept=deptRepo.save(dept);
			return EmployeeMapper.mapToDepartmentDto(dept);
		}
		else
			return departmentDto;
	}

	public void deleteById(String deptId)
	{
		deptRepo.deleteById(deptId);
	}
	
	public  EmployeeDto findByDeptId(String deptId)
	{
		 Optional<Employee> deptById = deptRepo.findById(deptId);
		 return EmployeeMapper.mapToDepartmentDto(deptById.get());
	}
	
	public List<EmployeeDto> findAll()
	{
		return deptRepo.findAll().stream().map(EmployeeMapper :: mapToDepartmentDto).collect(Collectors.toList());
	}
	
}
