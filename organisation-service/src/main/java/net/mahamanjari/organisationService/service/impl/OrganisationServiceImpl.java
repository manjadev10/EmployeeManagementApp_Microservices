package net.mahamanjari.organisationService.service.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import net.mahamanjari.organisationService.dto.OrganisationDto;
import net.mahamanjari.organisationService.entity.Organisation;
import net.mahamanjari.organisationService.repository.OrganisationRepository;
import net.mahamanjari.organisationService.service.OrganisationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private ModelMapper modelMapper;
    private OrganisationRepository organisationRepository;

    @Override
    public OrganisationDto saveOrganisation(OrganisationDto organisationDto) {
        Organisation orgInput = modelMapper.map(organisationDto,Organisation.class);
        Organisation orgSaved = organisationRepository.save(orgInput);
        return modelMapper.map(orgSaved,OrganisationDto.class);
    }

    @Override
    public OrganisationDto getOrganisationByCode(String orgCode) {

        Organisation fetchedOrg = organisationRepository.findByOrganisationCode(orgCode);
        return modelMapper.map(fetchedOrg,OrganisationDto.class);
    }
}
