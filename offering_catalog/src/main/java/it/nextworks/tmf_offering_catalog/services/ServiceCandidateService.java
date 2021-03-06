package it.nextworks.tmf_offering_catalog.services;

import it.nextworks.tmf_offering_catalog.common.exception.NotExistingEntityException;
import it.nextworks.tmf_offering_catalog.information_models.common.ServiceSpecificationRef;
import it.nextworks.tmf_offering_catalog.information_models.common.TargetServiceSchema;
import it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidate;
import it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateCreate;
import it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateUpdate;
import it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryRef;
import it.nextworks.tmf_offering_catalog.repo.ServiceCandidateRepository;
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
public class ServiceCandidateService {

    private static final Logger log = LoggerFactory.getLogger(ServiceCandidateService.class);

    private static final String protocol = "http://";
    @Value("${server.hostname}")
    private String hostname;
    @Value("${server.port}")
    private String port;
    private static final String path = "/tmf-api/serviceCatalogManagement/v4/serviceCandidate/";

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
                .href(protocol + hostname + ":" + port + path + id)
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

        log.info("Service Candidate created with id " + id + ".");

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

    @Transactional
    public List<ServiceCandidate> list() {

        log.info("Received request to retrieve all Service Candidates.");

        List<ServiceCandidate> serviceCandidates = serviceCandidateRepository.findAll();
        for(ServiceCandidate sc : serviceCandidates) {
            sc.setCategory((List<ServiceCategoryRef>) Hibernate.unproxy(sc.getCategory()));
            sc.setServiceSpecification((ServiceSpecificationRef) Hibernate.unproxy(sc.getServiceSpecification()));

            ServiceSpecificationRef ssr = sc.getServiceSpecification();
            if(ssr != null)
                ssr.setTargetServiceSchema((TargetServiceSchema) Hibernate.unproxy(ssr.getTargetServiceSchema()));
        }

        log.info("Service Candidates retrieved.");

        return serviceCandidates;
    }

    public ServiceCandidate patch(String id, ServiceCandidateUpdate serviceCandidateUpdate, String lastUpdate)
        throws NotExistingEntityException {

        log.info("Received request to patch Service Candidate with id " + id + ".");

        Optional<ServiceCandidate> toUpdate = serviceCandidateRepository.findByServiceCandidateId(id);
        if(!toUpdate.isPresent())
            throw new NotExistingEntityException("Service Candidate with id " + id + " not found in DB.");

        ServiceCandidate serviceCandidate = toUpdate.get();

        serviceCandidate.setBaseType(serviceCandidateUpdate.getBaseType());
        serviceCandidate.setSchemaLocation(serviceCandidateUpdate.getSchemaLocation());
        serviceCandidate.setType(serviceCandidateUpdate.getType());

        final List<ServiceCategoryRef> category = serviceCandidateUpdate.getCategory();
        if(serviceCandidate.getCategory() == null)
            serviceCandidate.setCategory(category);
        else if(category != null) {
            serviceCandidate.getCategory().clear();
            serviceCandidate.getCategory().addAll(category);
        }
        else
            serviceCandidate.getCategory().clear();

        serviceCandidate.setDescription(serviceCandidateUpdate.getDescription());
        serviceCandidate.setLastUpdate(lastUpdate);
        serviceCandidate.setLifecycleStatus(serviceCandidateUpdate.getLifecycleStatus());
        serviceCandidate.setName(serviceCandidateUpdate.getName());
        serviceCandidate.setServiceSpecification(serviceCandidateUpdate.getServiceSpecification());
        serviceCandidate.setValidFor(serviceCandidateUpdate.getValidFor());
        serviceCandidate.setVersion(serviceCandidateUpdate.getVersion());

        serviceCandidateRepository.save(serviceCandidate);

        log.info("Service Candidate " + id + " patched.");

        return serviceCandidate;
    }

    @Transactional
    public ServiceCandidate get(String id) throws NotExistingEntityException {

        log.info("Received request to retrieve Service Candidate with id " + id + ".");

        Optional<ServiceCandidate> retrieved = serviceCandidateRepository.findByServiceCandidateId(id);
        if(!retrieved.isPresent())
            throw new NotExistingEntityException("Service Candidate with id " + id + " not found in DB.");

        ServiceCandidate sc = retrieved.get();

        sc.setCategory((List<ServiceCategoryRef>) Hibernate.unproxy(sc.getCategory()));
        sc.setServiceSpecification((ServiceSpecificationRef) Hibernate.unproxy(sc.getServiceSpecification()));

        ServiceSpecificationRef ssr = sc.getServiceSpecification();
        if(ssr != null)
            ssr.setTargetServiceSchema((TargetServiceSchema) Hibernate.unproxy(ssr.getTargetServiceSchema()));

        log.info("Service Candidate " + id + " retrieved.");

        return sc;
    }
}
