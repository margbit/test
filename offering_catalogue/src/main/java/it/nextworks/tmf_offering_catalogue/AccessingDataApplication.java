package it.nextworks.tmf_offering_catalogue;

import it.nextworks.tmf_offering_catalogue.information_models.resource.ResourceCandidate;
import it.nextworks.tmf_offering_catalogue.information_models.resource.ResourceCategoryRef;
import it.nextworks.tmf_offering_catalogue.repo.ResourceCandidateRepository;
import it.nextworks.tmf_offering_catalogue.repo.ResourceCategoryRefRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
@Transactional
public class AccessingDataApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataApplication.class);
    }

    @Bean
    public CommandLineRunner demo(ResourceCandidateRepository resourceCandidateRepository,
                                  ResourceCategoryRefRepository resourceCategoryRefRepository) {
        return(args) -> {
            ResourceCandidate resourceCandidate = new ResourceCandidate();
            ResourceCategoryRef resourceCategoryRef = new ResourceCategoryRef().name("pluto");
            ArrayList<ResourceCategoryRef> lst = new ArrayList<>();
            lst.add(resourceCategoryRef);
            resourceCandidate = resourceCandidate.category(lst).id("12345");
            ResourceCandidate saved = resourceCandidateRepository.save(resourceCandidate);

            // fetch all customers
            log.info("ResourceCandidate found with findAll():");
            log.info("-------------------------------");
            ResourceCandidate tmp = resourceCandidateRepository.findByResourceCandidateId("12345").get();
            log.info(tmp.getUuid());
            log.info("-------------------------------");
        };
    }
}
