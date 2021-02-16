package it.nextworks.tmf_offering_catalogue.repo;

import it.nextworks.tmf_offering_catalogue.information_models.product.ProductSpecificationCharacteristicValueUse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpecificationCharacteristicValueUseRepository
        extends JpaRepository<ProductSpecificationCharacteristicValueUse, String> { }