package it.nextworks.tmf_offering_catalogue.repo;

import it.nextworks.tmf_offering_catalogue.information_models.product.BundledProductOfferingOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BundledProductOfferingOptionRepository extends JpaRepository<BundledProductOfferingOption, String> { }