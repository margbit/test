package it.nextworks.tmf_offering_catalog.information_models.product;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.tmf_offering_catalog.information_models.common.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role.
 */
@ApiModel(description = "Is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-09T15:56:41.618Z")

@Entity
@Table(name = "product_specifications")
public class ProductSpecification {

  @JsonProperty("@baseType")
  @Column(name = "base_type")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  @Column(name = "schema_location")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("attachment")
  @Valid
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "product_specification_fk", referencedColumnName = "uuid")
  private List<AttachmentRefOrValue> attachment = null;

  @JsonProperty("brand")
  private String brand = null;

  @JsonProperty("bundledProductSpecification")
  @Valid
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "product_specification_fk", referencedColumnName = "uuid")
  private List<BundledProductSpecification> bundledProductSpecification = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("isBundle")
  @Column(name = "is_bundle")
  private Boolean isBundle = null;

  @JsonProperty("lastUpdate")
  @Column(name = "last_update")
  private String lastUpdate = null;

  @JsonProperty("lifecycleStatus")
  @Column(name = "lifecycle_status")
  private String lifecycleStatus = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("productNumber")
  @Column(name = "product_number")
  private String productNumber = null;

  @JsonProperty("productSpecCharacteristic")
  @Valid
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "product_specification_fk", referencedColumnName = "uuid")
  private List<ProductSpecificationCharacteristic> productSpecCharacteristic = null;

  @JsonProperty("productSpecificationRelationship")
  @Valid
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "product_specification_fk", referencedColumnName = "uuid")
  private List<ProductSpecificationRelationship> productSpecificationRelationship = null;

  @JsonProperty("relatedParty")
  @Valid
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "product_specification_fk", referencedColumnName = "uuid")
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("resourceSpecification")
  @Valid
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "product_specification_fk", referencedColumnName = "uuid")
  private List<ResourceSpecificationRef> resourceSpecification = null;

  @JsonProperty("serviceSpecification")
  @Valid
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "product_specification_fk", referencedColumnName = "uuid")
  private List<ServiceSpecificationRef> serviceSpecification = null;

  @JsonProperty("targetProductSchema")
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "target_product_schema_id", referencedColumnName = "uuid")
  private TargetProductSchema targetProductSchema = null;

  @JsonIgnore
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid = null;

  @JsonProperty("validFor")
  @Column(name = "valid_for")
  @Embedded
  private TimePeriod validFor = null;

  @JsonProperty("version")
  private String version = null;

  public ProductSpecification baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ProductSpecification schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ProductSpecification type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProductSpecification attachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
    return this;
  }

  public ProductSpecification addAttachmentItem(AttachmentRefOrValue attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<AttachmentRefOrValue>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * Complements the description of an element (for instance a product) through video, pictures...
   * @return attachment
  **/
  @ApiModelProperty(value = "Complements the description of an element (for instance a product) through video, pictures...")

  @Valid

  public List<AttachmentRefOrValue> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
  }

  public ProductSpecification brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * The manufacturer or trademark of the specification
   * @return brand
  **/
  @ApiModelProperty(value = "The manufacturer or trademark of the specification")


  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public ProductSpecification bundledProductSpecification(List<BundledProductSpecification> bundledProductSpecification) {
    this.bundledProductSpecification = bundledProductSpecification;
    return this;
  }

  public ProductSpecification addBundledProductSpecificationItem(BundledProductSpecification bundledProductSpecificationItem) {
    if (this.bundledProductSpecification == null) {
      this.bundledProductSpecification = new ArrayList<BundledProductSpecification>();
    }
    this.bundledProductSpecification.add(bundledProductSpecificationItem);
    return this;
  }

  /**
   * A type of ProductSpecification that belongs to a grouping of ProductSpecifications made available to the market. It inherits of all attributes of ProductSpecification.
   * @return bundledProductSpecification
  **/
  @ApiModelProperty(value = "A type of ProductSpecification that belongs to a grouping of ProductSpecifications made available to the market. It inherits of all attributes of ProductSpecification.")

  @Valid

  public List<BundledProductSpecification> getBundledProductSpecification() {
    return bundledProductSpecification;
  }

  public void setBundledProductSpecification(List<BundledProductSpecification> bundledProductSpecification) {
    this.bundledProductSpecification = bundledProductSpecification;
  }

  public ProductSpecification description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of this catalog
   * @return description
  **/
  @ApiModelProperty(value = "Description of this catalog")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductSpecification href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the entity
   * @return href
  **/
  @ApiModelProperty(value = "Unique reference of the entity")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductSpecification id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the product specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the product specification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductSpecification isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * isBundle determines whether a productSpecification represents a single productSpecification (false), or a bundle of productSpecification (true).
   * @return isBundle
  **/
  @ApiModelProperty(value = "isBundle determines whether a productSpecification represents a single productSpecification (false), or a bundle of productSpecification (true).")


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ProductSpecification lastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date and time of the last update")


  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public ProductSpecification lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Used to indicate the current lifecycle status")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ProductSpecification name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the entity
   * @return name
  **/
  @ApiModelProperty(value = "Name of the entity")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductSpecification productNumber(String productNumber) {
    this.productNumber = productNumber;
    return this;
  }

  /**
   * An identification number assigned to uniquely identity the specification
   * @return productNumber
  **/
  @ApiModelProperty(value = "An identification number assigned to uniquely identity the specification")


  public String getProductNumber() {
    return productNumber;
  }

  public void setProductNumber(String productNumber) {
    this.productNumber = productNumber;
  }

  public ProductSpecification productSpecCharacteristic(List<ProductSpecificationCharacteristic> productSpecCharacteristic) {
    this.productSpecCharacteristic = productSpecCharacteristic;
    return this;
  }

  public ProductSpecification addProductSpecCharacteristicItem(ProductSpecificationCharacteristic productSpecCharacteristicItem) {
    if (this.productSpecCharacteristic == null) {
      this.productSpecCharacteristic = new ArrayList<ProductSpecificationCharacteristic>();
    }
    this.productSpecCharacteristic.add(productSpecCharacteristicItem);
    return this;
  }

  /**
   * A characteristic quality or distinctive feature of a ProductSpecification.  The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.
   * @return productSpecCharacteristic
  **/
  @ApiModelProperty(value = "A characteristic quality or distinctive feature of a ProductSpecification.  The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.")

  @Valid

  public List<ProductSpecificationCharacteristic> getProductSpecCharacteristic() {
    return productSpecCharacteristic;
  }

  public void setProductSpecCharacteristic(List<ProductSpecificationCharacteristic> productSpecCharacteristic) {
    this.productSpecCharacteristic = productSpecCharacteristic;
  }

  public ProductSpecification productSpecificationRelationship(List<ProductSpecificationRelationship> productSpecificationRelationship) {
    this.productSpecificationRelationship = productSpecificationRelationship;
    return this;
  }

  public ProductSpecification addProductSpecificationRelationshipItem(ProductSpecificationRelationship productSpecificationRelationshipItem) {
    if (this.productSpecificationRelationship == null) {
      this.productSpecificationRelationship = new ArrayList<ProductSpecificationRelationship>();
    }
    this.productSpecificationRelationship.add(productSpecificationRelationshipItem);
    return this;
  }

  /**
   * A migration, substitution, dependency or exclusivity relationship between/among product specifications.
   * @return productSpecificationRelationship
  **/
  @ApiModelProperty(value = "A migration, substitution, dependency or exclusivity relationship between/among product specifications.")

  @Valid

  public List<ProductSpecificationRelationship> getProductSpecificationRelationship() {
    return productSpecificationRelationship;
  }

  public void setProductSpecificationRelationship(List<ProductSpecificationRelationship> productSpecificationRelationship) {
    this.productSpecificationRelationship = productSpecificationRelationship;
  }

  public ProductSpecification relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ProductSpecification addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<RelatedParty>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * A related party defines party or party role linked to a specific entity.
   * @return relatedParty
  **/
  @ApiModelProperty(value = "A related party defines party or party role linked to a specific entity.")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ProductSpecification resourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  public ProductSpecification addResourceSpecificationItem(ResourceSpecificationRef resourceSpecificationItem) {
    if (this.resourceSpecification == null) {
      this.resourceSpecification = new ArrayList<ResourceSpecificationRef>();
    }
    this.resourceSpecification.add(resourceSpecificationItem);
    return this;
  }

  /**
   * The ResourceSpecification is required to realize a ProductSpecification.
   * @return resourceSpecification
  **/
  @ApiModelProperty(value = "The ResourceSpecification is required to realize a ProductSpecification.")

  @Valid

  public List<ResourceSpecificationRef> getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ProductSpecification serviceSpecification(List<ServiceSpecificationRef> serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
    return this;
  }

  public ProductSpecification addServiceSpecificationItem(ServiceSpecificationRef serviceSpecificationItem) {
    if (this.serviceSpecification == null) {
      this.serviceSpecification = new ArrayList<ServiceSpecificationRef>();
    }
    this.serviceSpecification.add(serviceSpecificationItem);
    return this;
  }

  /**
   * ServiceSpecification(s) required to realize a ProductSpecification.
   * @return serviceSpecification
  **/
  @ApiModelProperty(value = "ServiceSpecification(s) required to realize a ProductSpecification.")

  @Valid

  public List<ServiceSpecificationRef> getServiceSpecification() {
    return serviceSpecification;
  }

  public void setServiceSpecification(List<ServiceSpecificationRef> serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
  }

  public ProductSpecification targetProductSchema(TargetProductSchema targetProductSchema) {
    this.targetProductSchema = targetProductSchema;
    return this;
  }

  /**
   * A target product schema reference. The reference object to the schema and type of target product which is described by product specification.
   * @return targetProductSchema
  **/
  @ApiModelProperty(value = "A target product schema reference. The reference object to the schema and type of target product which is described by product specification.")

  @Valid

  public TargetProductSchema getTargetProductSchema() {
    return targetProductSchema;
  }

  public void setTargetProductSchema(TargetProductSchema targetProductSchema) {
    this.targetProductSchema = targetProductSchema;
  }

  public ProductSpecification uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "")


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public ProductSpecification validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the entity is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the entity is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ProductSpecification version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Entity version
   * @return version
  **/
  @ApiModelProperty(value = "Entity version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductSpecification productSpecification = (ProductSpecification) o;
    return Objects.equals(this.baseType, productSpecification.baseType) &&
        Objects.equals(this.schemaLocation, productSpecification.schemaLocation) &&
        Objects.equals(this.type, productSpecification.type) &&
        Objects.equals(this.attachment, productSpecification.attachment) &&
        Objects.equals(this.brand, productSpecification.brand) &&
        Objects.equals(this.bundledProductSpecification, productSpecification.bundledProductSpecification) &&
        Objects.equals(this.description, productSpecification.description) &&
        Objects.equals(this.href, productSpecification.href) &&
        Objects.equals(this.id, productSpecification.id) &&
        Objects.equals(this.isBundle, productSpecification.isBundle) &&
        Objects.equals(this.lastUpdate, productSpecification.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, productSpecification.lifecycleStatus) &&
        Objects.equals(this.name, productSpecification.name) &&
        Objects.equals(this.productNumber, productSpecification.productNumber) &&
        Objects.equals(this.productSpecCharacteristic, productSpecification.productSpecCharacteristic) &&
        Objects.equals(this.productSpecificationRelationship, productSpecification.productSpecificationRelationship) &&
        Objects.equals(this.relatedParty, productSpecification.relatedParty) &&
        Objects.equals(this.resourceSpecification, productSpecification.resourceSpecification) &&
        Objects.equals(this.serviceSpecification, productSpecification.serviceSpecification) &&
        Objects.equals(this.targetProductSchema, productSpecification.targetProductSchema) &&
        Objects.equals(this.uuid, productSpecification.uuid) &&
        Objects.equals(this.validFor, productSpecification.validFor) &&
        Objects.equals(this.version, productSpecification.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, attachment, brand, bundledProductSpecification, description, href, id, isBundle, lastUpdate, lifecycleStatus, name, productNumber, productSpecCharacteristic, productSpecificationRelationship, relatedParty, resourceSpecification, serviceSpecification, targetProductSchema, uuid, validFor, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecification {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    bundledProductSpecification: ").append(toIndentedString(bundledProductSpecification)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productNumber: ").append(toIndentedString(productNumber)).append("\n");
    sb.append("    productSpecCharacteristic: ").append(toIndentedString(productSpecCharacteristic)).append("\n");
    sb.append("    productSpecificationRelationship: ").append(toIndentedString(productSpecificationRelationship)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
    sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
    sb.append("    targetProductSchema: ").append(toIndentedString(targetProductSchema)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

