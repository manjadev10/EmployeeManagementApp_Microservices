package net.mahamanjari.employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResonseDto {

    private EmployeeDto employee;
    private DepartmentDto department;
    private OrganisationDto organisation;

}
