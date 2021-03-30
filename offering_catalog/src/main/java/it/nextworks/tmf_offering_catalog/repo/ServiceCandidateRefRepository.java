package it.nextworks.tmf_offering_catalog.repo;

import it.nextworks.tmf_offering_catalog.information_models.common.ServiceCandidateRef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCandidateRefRepository extends JpaRepository<ServiceCandidateRef, String> { }
