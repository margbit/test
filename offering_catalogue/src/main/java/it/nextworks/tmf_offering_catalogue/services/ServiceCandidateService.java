package it.nextworks.tmf_offering_catalogue.services;

import it.nextworks.tmf_offering_catalogue.common.exception.NotExistingEntityException;
import it.nextworks.tmf_offering_catalogue.information_models.ServiceSpecificationRef;
import it.nextworks.tmf_offering_catalogue.information_models.TimePeriod;
import it.nextworks.tmf_offering_catalogue.information_models.service.ServiceCandidate;
import it.nextworks.tmf_offering_catalogue.information_models.service.ServiceCandidateCreate;
import it.nextworks.tmf_offering_catalogue.information_models.service.ServiceCandidateUpdate;
import it.nextworks.tmf_offering_catalogue.information_models.service.ServiceCategoryRef;
import it.nextworks.tmf_offering_catalogue.repo.ServiceCandidateRepository;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.OffsetDateTime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ServiceCandidateService {

    private static final Logger log = LoggerFactory.getLogger(ServiceCandidateService.class);

    private static final String protocol = "http://";
    @Value("${server.hostname}")
    private String hostname;
    @Value("${server.port}")
    private String port;
    private static final String path = "/serviceCatalogManagement/v4/serviceCandidate/";

    @Autowired
    private ServiceCandidateRepository serviceCandidateRepository;

    public ServiceCandidate create(ServiceCandidateCreate serviceCandidateCreate) {

        log.info("Received request to create a Service Specification.");

        final String id = UUID.randomUUID().toString();
        ServiceCandidate serviceCandidate = new ServiceCandidate()
                .baseType(serviceCandidateCreate.getBaseType())
                .schemaLocation(serviceCandidateCreate.getSchemaLocation())
                .type(serviceCandidateCreate.getType())
                .category(serviceCandidateCreate.getCategory())
                .description(serviceCandidateCreate.getDescription())
                .href(protocol + hostname + port + path + id)
                .id(id)
                .lifecycleStatus(serviceCandidateCreate.getLifecycleStatus())
                .name(serviceCandidateCreate.getName())
                .serviceSpecification(serviceCandidateCreate.getServiceSpecification())
                .validFor(serviceCandidateCreate.getValidFor())
                .version(serviceCandidateCreate.getVersion());

        final OffsetDateTime lastUpdate = serviceCandidateCreate.getLastUpdate();
        if(lastUpdate != null)
            serviceCandidate.setLastUpdate(lastUpdate.toString());

        serviceCandidateRepository.save(serviceCandidate);

        log.info("Service Candidate created with id " + serviceCandidate.getId() + ".");

        return serviceCandidate;
    }

    public void delete(String id) throws NotExistingEntityException {

        log.info("Received request to delete Service Candidate with id " + id + ".");

        Optional<ServiceCandidate> toDelete = serviceCandidateRepository.findByServiceCandidateId(id);
        if(!toDelete.isPresent())
            throw new NotExistingEntityException("Service Candidate with id " + id + " not found in DB.");

        serviceCandidateRepository.delete(toDelete.get());

        log.info("Service Candidate " + id + " deleted");
    }

    public List<ServiceCandidate> list() {

        List<ServiceCandidate> serviceCandidates = serviceCandidateRepository.findAll();
        for(ServiceCandidate sc : serviceCandidates) {
            Hibernate.initialize(sc.getCategory());
            Hibernate.initialize(sc.getServiceSpecification().getTargetServiceSchema());
        }

        return serviceCandidates;
    }

    public ServiceCandidate patch(String id, ServiceCandidateUpdate serviceCandidateUpdate)
        throws NotExistingEntityException {

        log.info("Received request to patch Service Candidate with id " + id + ".");

        Optional<ServiceCandidate> toUpdate = serviceCandidateRepository.findByServiceCandidateId(id);
        if(!toUpdate.isPresent())
            throw new NotExistingEntityException("Service Candidate with id " + id + " not found in DB.");

        ServiceCandidate serviceCandidate = toUpdate.get();

        final String baseType = serviceCandidateUpdate.getBaseType();
        if(baseType != null)
            serviceCandidate.setBaseType(baseType);

        final String schemaLocation = serviceCandidateUpdate.getSchemaLocation();
        if(schemaLocation != null)
            serviceCandidate.setSchemaLocation(schemaLocation);

        final String type = serviceCandidateUpdate.getType();
        if(type != null)
            serviceCandidate.setType(type);

        final List<ServiceCategoryRef> category = serviceCandidateUpdate.getCategory();
        if(category != null)
            serviceCandidate.setCategory(category);

        final String description = serviceCandidateUpdate.getDescription();
        if(description != null)
            serviceCandidate.setDescription(description);

        final String lifecycleStatus = serviceCandidateUpdate.getLifecycleStatus();
        if(lifecycleStatus != null)
            serviceCandidate.setLifecycleStatus(lifecycleStatus);

        final String name = serviceCandidateUpdate.getName();
        if(name != null)
            serviceCandidate.setName(name);

        final ServiceSpecificationRef serviceSpecification = serviceCandidateUpdate.getServiceSpecification();
        if(serviceSpecification != null)
            serviceCandidate.setServiceSpecification(serviceSpecification);

        final TimePeriod validFor = serviceCandidateUpdate.getValidFor();
        if(validFor != null)
            serviceCandidate.setValidFor(validFor);

        final String version = serviceCandidateUpdate.getVersion();
        if(version != null)
            serviceCandidate.setVersion(version);

        serviceCandidateRepository.save(serviceCandidate);

        log.info("Service Candidate " + id + " patched.");

        return serviceCandidate;
    }

    public ServiceCandidate get(String id) throws NotExistingEntityException {

        Optional<ServiceCandidate> retrieved = serviceCandidateRepository.findByServiceCandidateId(id);
        if(!retrieved.isPresent())
            throw new NotExistingEntityException("Service Candidate with id " + id + " not found in DB.");

        ServiceCandidate serviceCandidate = retrieved.get();

        Hibernate.initialize(serviceCandidate.getCategory());
        Hibernate.initialize(serviceCandidate.getServiceSpecification().getTargetServiceSchema());

        return serviceCandidate;
    }
}
