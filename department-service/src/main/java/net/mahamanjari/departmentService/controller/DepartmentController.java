package net.mahamanjari.departmentService.controller;

import lombok.AllArgsConstructor;
import net.mahamanjari.departmentService.dto.DepartmentDto;
import net.mahamanjari.departmentService.entity.Department;
import net.mahamanjari.departmentService.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping("{dept-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("dept-code") String deptCode){
        DepartmentDto deptFetched = departmentService.getDepartmentByCode(deptCode);
        return new ResponseEntity<>(deptFetched,HttpStatus.OK);
    }

}
