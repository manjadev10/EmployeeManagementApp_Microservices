package net.mahamanjari.employeeService.service;

import net.mahamanjari.employeeService.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface myFeignClient {

    @GetMapping("api/departments/{dept-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("dept-code") String deptCode);

}
