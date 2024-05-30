package net.mahamanjari.organisationService.controller;

import lombok.AllArgsConstructor;
import net.mahamanjari.organisationService.dto.OrganisationDto;
import net.mahamanjari.organisationService.service.OrganisationService;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/organisations")
public class OrganisationController {

    private OrganisationService organisationService;

    @PostMapping
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto orgDto){
        OrganisationDto savedOrgDto = organisationService.saveOrganisation(orgDto);
        return new ResponseEntity<>(savedOrgDto,HttpStatus.CREATED);
    }

    @GetMapping("{orgCode}")
    public ResponseEntity<OrganisationDto> getOrganisationByCode(@PathVariable("orgCode") String orgCode){
        OrganisationDto orgDto = organisationService.getOrganisationByCode(orgCode);
        return new ResponseEntity<>(orgDto,HttpStatus.OK);
    }

}
