package com.company.mapper;

import com.company.dto.EmployeeDto;
import com.company.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToDepartmentDto(Employee department)
	{
		return EmployeeDto.builder()
				.empId(department.getEmpId())
				.empName(department.getEmpName())
				.createdBy(department.getCreatedBy())
				.createdOn(department.getCreatedOn())
				.modifiedBy(department.getModifiedBy())
				.modifiedOn(department.getModifiedOn())
				.build();
	}
	
	public static Employee mapToDepartment(EmployeeDto departmentDto)
	{
		return Employee.builder()
				.empId(departmentDto.getEmpId())
				.empName(departmentDto.getEmpName())
				.createdBy(departmentDto.getCreatedBy())
				.createdOn(departmentDto.getCreatedOn())
				.modifiedBy(departmentDto.getModifiedBy())
				.modifiedOn(departmentDto.getModifiedOn())
				.build();
	}
}
