package net.mahamanjari.organisationService.repository;

import net.mahamanjari.organisationService.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

    public Organisation findByOrganisationCode(String orgCode);

}
