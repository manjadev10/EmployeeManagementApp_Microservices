package net.mahamanjari.employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationDto {

    private Long id;
    private String organisationName;
    private String organisationDescription;
    private String organisationCode;
    private LocalDateTime createdDate;

}
