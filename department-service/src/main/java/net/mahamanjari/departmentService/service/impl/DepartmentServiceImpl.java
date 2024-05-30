package net.mahamanjari.departmentService.service.impl;


import lombok.AllArgsConstructor;
import net.mahamanjari.departmentService.dto.DepartmentDto;
import net.mahamanjari.departmentService.entity.Department;
import net.mahamanjari.departmentService.exception.ResourceNotFoundException;
import net.mahamanjari.departmentService.repository.DepartmentRepository;
import net.mahamanjari.departmentService.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    //Use Modelmapper library for Dto conversions
    private ModelMapper modelMapper;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
            Department deptIn = modelMapper.map(departmentDto, Department.class);
            Department deptSaved = departmentRepository.save(deptIn);
            return modelMapper.map(deptSaved,DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String deptCode) {

        Department deptFetched= departmentRepository.findByDepartmentCode(deptCode).orElseThrow(
                ()->new ResourceNotFoundException("Department Not found for deptCode :"+deptCode)
        );
        return modelMapper.map(deptFetched,DepartmentDto.class);
    }

}
