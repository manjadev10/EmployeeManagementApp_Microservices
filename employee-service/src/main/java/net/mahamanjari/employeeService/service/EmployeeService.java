package net.mahamanjari.employeeService.service;

import net.mahamanjari.employeeService.dto.APIResonseDto;
import net.mahamanjari.employeeService.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResonseDto getEmployeeById(Long id);
}
