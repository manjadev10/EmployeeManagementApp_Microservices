package net.mahamanjari.employeeService.service.impl;

import lombok.AllArgsConstructor;
import net.mahamanjari.employeeService.dto.APIResonseDto;
import net.mahamanjari.employeeService.dto.DepartmentDto;
import net.mahamanjari.employeeService.dto.EmployeeDto;
import net.mahamanjari.employeeService.dto.OrganisationDto;
import net.mahamanjari.employeeService.entity.Employee;
import net.mahamanjari.employeeService.exception.EmailAlreadyExistsException;
import net.mahamanjari.employeeService.exception.ResourceNotFoundException;
import net.mahamanjari.employeeService.repository.EmployeeRepository;
import net.mahamanjari.employeeService.service.myFeignClient;
import net.mahamanjari.employeeService.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
//    private RestTemplate restTemplate;
    private WebClient webClient;
    private myFeignClient myFeignClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> isEmpExists = employeeRepository.findByEmail(employeeDto.getEmail());
        if(isEmpExists.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists for a employee");
        }
        Employee employeeIn = modelMapper.map(employeeDto,Employee.class);
        Employee employeeFetched = employeeRepository.save(employeeIn);
        return modelMapper.map(employeeFetched,EmployeeDto.class);
    }

    @Override
//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
//    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResonseDto getEmployeeById(Long id) {
        LOGGER.info("inside getEmployeeById() method");
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee","id",id)
        );
        EmployeeDto employeeDto = modelMapper.map(existingEmployee,EmployeeDto.class);

//      ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+existingEmployee.getDepartmentCode(), DepartmentDto.class);
//      DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8082/api/departments/"+existingEmployee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = myFeignClient.getDepartmentByCode(existingEmployee.getDepartmentCode());

        OrganisationDto organisationDto = webClient.get()
            .uri("http://localhost:8083/api/organisations/"+existingEmployee.getOrganisationCode())
            .retrieve()
            .bodyToMono(OrganisationDto.class)
            .block();

        APIResonseDto apiResonseDto = new APIResonseDto(employeeDto,departmentDto,organisationDto);
        return apiResonseDto;
    }


    public APIResonseDto getDefaultDepartment(Long id, Exception exception) {
        LOGGER.info("inside getDefaultDepartment() method");
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee","id",id)
        );
        EmployeeDto employeeDto = modelMapper.map(existingEmployee,EmployeeDto.class);

        //Default Department
        DepartmentDto departmentDto = new DepartmentDto();

        OrganisationDto organisationDto = new OrganisationDto();

        APIResonseDto apiResonseDto = new APIResonseDto(employeeDto,departmentDto,organisationDto);
        return apiResonseDto;
    }
}
