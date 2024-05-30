package net.mahamanjari.employeeService.controller;

import lombok.AllArgsConstructor;
import net.mahamanjari.employeeService.dto.APIResonseDto;
import net.mahamanjari.employeeService.dto.EmployeeDto;
import net.mahamanjari.employeeService.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto){
        EmployeeDto empDtoSaved = employeeService.saveEmployee(empDto);
        return new ResponseEntity<>(empDtoSaved, HttpStatus.CREATED);

    }

    @GetMapping("{empId}")
    public ResponseEntity<APIResonseDto> getEmployeeId(@PathVariable("empId") Long empId){
        APIResonseDto apiResonseDto = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(apiResonseDto,HttpStatus.OK);
    }


}
