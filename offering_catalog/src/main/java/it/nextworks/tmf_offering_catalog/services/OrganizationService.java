package it.nextworks.tmf_offering_catalog.services;

import it.nextworks.tmf_offering_catalog.common.exception.NotExistingEntityException;
import it.nextworks.tmf_offering_catalog.common.exception.StakeholderAlreadyRegisteredException;
import it.nextworks.tmf_offering_catalog.information_models.common.AttachmentRefOrValue;
import it.nextworks.tmf_offering_catalog.information_models.common.RelatedParty;
import it.nextworks.tmf_offering_catalog.information_models.party.*;
import it.nextworks.tmf_offering_catalog.repo.OrganizationRepository;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class OrganizationService {

    private static final Logger log = LoggerFactory.getLogger(OrganizationService.class);

    private static final String protocol = "http://";
    @Value("${server.hostname}")
    private String hostname;
    @Value("${server.port}")
    private String port;
    private static final String path = "/tmf-api/party/v4/organization/";

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization create(OrganizationCreate organizationCreate) throws StakeholderAlreadyRegisteredException {

        log.info("Received request to create an Organization.");

        if(organizationRepository.findAll().size() == 1)
            throw new StakeholderAlreadyRegisteredException("Stakeholder already registered.");

        final String id = UUID.randomUUID().toString();
        Organization organization = new Organization()
                .baseType(organizationCreate.getBaseType())
                .schemaLocation(organizationCreate.getSchemaLocation())
                .type(organizationCreate.getType())
                .contactMedium(organizationCreate.getContactMedium())
                .creditRating(organizationCreate.getCreditRating())
                .existsDuring(organizationCreate.getExistsDuring())
                .externalReference(organizationCreate.getExternalReference())
                .href(protocol + hostname + ":" + port + path + id)
                .id(id)
                .isHeadOffice(organizationCreate.isIsHeadOffice())
                .isLegalEntity(organizationCreate.isIsLegalEntity())
                .name(organizationCreate.getName())
                .nameType(organizationCreate.getNameType())
                .organizationChildRelationship(organizationCreate.getOrganizationChildRelationship())
                .organizationIdentification(organizationCreate.getOrganizationIdentification())
                .organizationParentRelationship(organizationCreate.getOrganizationParentRelationship())
                .organizationType(organizationCreate.getOrganizationType())
                .otherName(organizationCreate.getOtherName())
                .partyCharacteristic(organizationCreate.getPartyCharacteristic())
                .relatedParty(organizationCreate.getRelatedParty())
                .status(organizationCreate.getStatus())
                .taxExemptionCertificate(organizationCreate.getTaxExemptionCertificate())
                .tradingName(organizationCreate.getTradingName());

        organizationRepository.save(organization);

        //log.info("Requesting stakeholder registration via CommunicationService to ID&P.");
        // TODO: register stakeholder via ID&P in order to receive credential (stakeholder did and token)
        //log.info("Stakeholder registration successfully completed via ID&P.");

        log.info("Organization created with id " + id + ".");

        return organization;
    }

    public void delete(String id) throws NotExistingEntityException {

        log.info("Received request to delete Organization with id " + id + ".");

        Optional<Organization> toDelete = organizationRepository.findByOrganizationId(id);
        if(!toDelete.isPresent())
            throw new NotExistingEntityException("Organization with id " + id + " not found in DB.");

         // TODO: revoke stakeholder registration/credential?
        organizationRepository.delete(toDelete.get());

        log.info("Organization " + id + " deleted.");
    }

    public Organization patch(String id, OrganizationUpdate organizationUpdate) throws NotExistingEntityException {

        log.info("Received request to patch Organization with id " + id + ".");

        Optional<Organization> toUpdate = organizationRepository.findByOrganizationId(id);
        if(!toUpdate.isPresent())
            throw new NotExistingEntityException("Organization with id " + id + " not found in DB.");

        Organization organization = toUpdate.get();

        // TODO: revoke stakeholder registration/credential?

        organization.setBaseType(organizationUpdate.getBaseType());
        organization.setSchemaLocation(organizationUpdate.getSchemaLocation());
        organization.setType(organizationUpdate.getType());

        final List<ContactMedium> contactMedium = organizationUpdate.getContactMedium();
        if(organization.getContactMedium() == null)
            organization.setContactMedium(contactMedium);
        else if(contactMedium != null) {
            organization.getContactMedium().clear();
            organization.getContactMedium().addAll(contactMedium);
        }
        else
            organization.getContactMedium().clear();

        final List<PartyCreditProfile> creditRating = organizationUpdate.getCreditRating();
        if(organization.getCreditRating() == null)
            organization.setCreditRating(creditRating);
        else if(creditRating != null) {
            organization.getCreditRating().clear();
            organization.getCreditRating().addAll(creditRating);
        }
        else
            organization.getCreditRating().clear();

        organization.setExistsDuring(organizationUpdate.getExistsDuring());

        final List<ExternalReference> externalReference = organizationUpdate.getExternalReference();
        if(organization.getExternalReference() == null)
            organization.setExternalReference(externalReference);
        else if(externalReference != null) {
            organization.getExternalReference().clear();
            organization.getExternalReference().addAll(externalReference);
        }
        else
            organization.getExternalReference().clear();

        organization.setIsHeadOffice(organizationUpdate.isIsHeadOffice());
        organization.setIsLegalEntity(organizationUpdate.isIsLegalEntity());
        organization.setName(organizationUpdate.getName());
        organization.setNameType(organizationUpdate.getNameType());

        final List<OrganizationChildRelationship> organizationChildRelationship =
                organizationUpdate.getOrganizationChildRelationship();
        if(organization.getOrganizationChildRelationship() == null)
            organization.setOrganizationChildRelationship(organizationChildRelationship);
        else if(organizationChildRelationship != null) {
            organization.getOrganizationChildRelationship().clear();
            organization.getOrganizationChildRelationship().addAll(organizationChildRelationship);
        }
        else
            organization.getOrganizationChildRelationship().clear();

        final List<OrganizationIdentification> organizationIdentification =
                organizationUpdate.getOrganizationIdentification();
        if(organization.getOrganizationIdentification() == null)
            organization.setOrganizationIdentification(organizationIdentification);
        else if(organizationIdentification != null) {
            organization.getOrganizationIdentification().clear();
            organization.getOrganizationIdentification().addAll(organizationIdentification);
        }
        else
            organization.getOrganizationIdentification().clear();

        organization.setOrganizationParentRelationship(organizationUpdate.getOrganizationParentRelationship());
        organization.setOrganizationType(organizationUpdate.getOrganizationType());

        final List<OtherNameOrganization> otherName = organizationUpdate.getOtherName();
        if(organization.getOtherName() == null)
            organization.setOtherName(otherName);
        else if(otherName != null) {
            organization.getOtherName().clear();
            organization.getOtherName().addAll(otherName);
        }
        else
            organization.getOtherName().clear();

        final List<Characteristic> partyCharacteristic = organizationUpdate.getPartyCharacteristic();
        if(organization.getPartyCharacteristic() == null)
            organization.setPartyCharacteristic(partyCharacteristic);
        else if(partyCharacteristic != null) {
            organization.getPartyCharacteristic().clear();
            organization.getPartyCharacteristic().addAll(partyCharacteristic);
        }
        else
            organization.getPartyCharacteristic().clear();

        final List<RelatedParty> relatedParty = organizationUpdate.getRelatedParty();
        if(organization.getRelatedParty() == null)
            organization.setRelatedParty(relatedParty);
        else if(relatedParty != null) {
            organization.getRelatedParty().clear();
            organization.getRelatedParty().addAll(relatedParty);
        }
        else
            organization.getRelatedParty().clear();

        organization.setStatus(organizationUpdate.getStatus());

        final List<TaxExemptionCertificate> taxExemptionCertificate = organizationUpdate.getTaxExemptionCertificate();
        if(organization.getTaxExemptionCertificate() == null)
            organization.setTaxExemptionCertificate(taxExemptionCertificate);
        else if(taxExemptionCertificate != null) {
            organization.getTaxExemptionCertificate().clear();
            organization.getTaxExemptionCertificate().addAll(taxExemptionCertificate);
        }
        else
            organization.getTaxExemptionCertificate().clear();

        organization.setTradingName(organizationUpdate.getTradingName());

        organizationRepository.save(organization);

        log.info("Organization " + id + " patched.");

        return organization;
    }

    public Organization get(String id) throws NotExistingEntityException {

        log.info("Received request to retrieve Organization with id " + id + ".");

        Optional<Organization> retrieved = organizationRepository.findByOrganizationId(id);
        if(!retrieved.isPresent())
            throw new NotExistingEntityException("Organization with id " + id + " not found in DB.");

        Organization o = retrieved.get();

        o.setContactMedium((List<ContactMedium>) Hibernate.unproxy(o.getContactMedium()));
        if(o.getContactMedium() != null) {
            for(ContactMedium cm : o.getContactMedium())
                cm.setCharacteristic((MediumCharacteristic) Hibernate.unproxy(cm.getCharacteristic()));
        }

        o.setCreditRating((List<PartyCreditProfile>) Hibernate.unproxy(o.getCreditRating()));
        o.setExternalReference((List<ExternalReference>) Hibernate.unproxy(o.getExternalReference()));

        o.setOrganizationChildRelationship((List<OrganizationChildRelationship>)
                Hibernate.unproxy(o.getOrganizationChildRelationship()));
        if(o.getOrganizationChildRelationship() != null) {
            for(OrganizationChildRelationship ocr : o.getOrganizationChildRelationship())
                ocr.setOrganization((OrganizationRef) Hibernate.unproxy(ocr.getOrganization()));
        }

        o.setOrganizationIdentification((List<OrganizationIdentification>)
                Hibernate.unproxy(o.getOrganizationIdentification()));
        if(o.getOrganizationIdentification() != null) {
            for(OrganizationIdentification oi : o.getOrganizationIdentification())
                oi.setAttachment((AttachmentRefOrValue) Hibernate.unproxy(oi.getAttachment()));
        }

        o.setOrganizationParentRelationship((OrganizationParentRelationship)
                Hibernate.unproxy(o.getOrganizationParentRelationship()));
        if(o.getOrganizationParentRelationship() != null)
            o.getOrganizationParentRelationship().setOrganization((OrganizationRef)
                    Hibernate.unproxy(o.getOrganizationParentRelationship().getOrganization()));

        o.setOtherName((List<OtherNameOrganization>) Hibernate.unproxy(o.getOtherName()));
        o.setPartyCharacteristic((List<Characteristic>) Hibernate.unproxy(o.getPartyCharacteristic()));
        o.setRelatedParty((List<RelatedParty>) Hibernate.unproxy(o.getRelatedParty()));

        o.setTaxExemptionCertificate((List<TaxExemptionCertificate>)
                Hibernate.unproxy(o.getTaxExemptionCertificate()));
        if(o.getTaxExemptionCertificate() != null) {
            for(TaxExemptionCertificate tec : o.getTaxExemptionCertificate()) {
                tec.setAttachment((AttachmentRefOrValue) Hibernate.unproxy(tec.getAttachment()));
                tec.setTaxDefinition((List<TaxDefinition>) Hibernate.unproxy(tec.getTaxDefinition()));
            }
        }

        log.info("Organization " + id + " retrieved.");

        return o;
    }
}