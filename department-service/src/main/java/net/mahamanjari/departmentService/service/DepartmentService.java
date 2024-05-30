package net.mahamanjari.departmentService.service;


import net.mahamanjari.departmentService.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);

}
