package it.nextworks.tmf_offering_catalog.repo;

import it.nextworks.tmf_offering_catalog.information_models.party.ExternalReference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalReferenceRepository extends JpaRepository<ExternalReference, String> { }
