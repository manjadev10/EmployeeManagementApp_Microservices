package net.mahamanjari.organisationService.service;

import net.mahamanjari.organisationService.dto.OrganisationDto;
import net.mahamanjari.organisationService.entity.Organisation;

public interface OrganisationService {

    OrganisationDto saveOrganisation(OrganisationDto organisationDto);

    OrganisationDto getOrganisationByCode(String orgCode);

}
