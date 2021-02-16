package it.nextworks.tmf_offering_catalogue.information_models.product;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.nextworks.tmf_offering_catalogue.information_models.LifecycleStatusEnumEnum;
import it.nextworks.tmf_offering_catalogue.information_models.TimePeriod;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * The PricingLogicAlgorithm entity represents an instantiation of an interface specification to external rating function (without a modeled bahavior in SID). Some of the parameters of the interface definiition may be already set (such as price per unit) and some may be gathered during the rating process from the event (such as call duration) or from ProductCharacteristicValues (such as assigned bandwidth)
 */
@ApiModel(description = "The PricingLogicAlgorithm entity represents an instantiation of an interface specification to external rating function (without a modeled bahavior in SID). Some of the parameters of the interface definiition may be already set (such as price per unit) and some may be gathered during the rating process from the event (such as call duration) or from ProductCharacteristicValues (such as assigned bandwidth)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-09T15:56:41.618Z")

@Entity
@Table(name = "pricing_logic_algorithms")
public class PricingLogicAlgorithm {

  @JsonIgnore
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "jpa_id")
  private Long jpaId;

  @JsonProperty("@baseType")
  @Column(name = "base_type")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  @Column(name = "schema_location")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("lastUpdate")
  @Column(name = "last_update")
  private String lastUpdate = null;

  @JsonProperty("lifecycleStatus")
  @Column(name = "lifecycle_status")
  private String lifecycleStatus = null;

  @JsonProperty("lifecycleStatusEnum")
  @Column(name = "lifecycle_status_enum")
  private LifecycleStatusEnumEnum lifecycleStatusEnum = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("plaSpecId")
  @Column(name = "pla_spec_id")
  private String plaSpecId = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("validFor")
  @Column(name = "valid_for")
  @Embedded
  private TimePeriod validFor = null;

  @JsonProperty("version")
  private String version = null;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_offering_price_id")
  private ProductOfferingPrice productOfferingPrice;

  public PricingLogicAlgorithm baseType(String baseType) {
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

  public PricingLogicAlgorithm schemaLocation(String schemaLocation) {
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

  public PricingLogicAlgorithm type(String type) {
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

  public PricingLogicAlgorithm description(String description) {
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

  public PricingLogicAlgorithm href(String href) {
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

  public PricingLogicAlgorithm id(String id) {
    this.id = id;
    return this;
  }

  /**
   * unique id of the PricingLogicAlgorithm
   * @return id
  **/
  @ApiModelProperty(value = "unique id of the PricingLogicAlgorithm")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PricingLogicAlgorithm lastUpdate(String lastUpdate) {
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

  public PricingLogicAlgorithm lifecycleStatus(String lifecycleStatus) {
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

  public PricingLogicAlgorithm lifecycleStatusEnum(LifecycleStatusEnumEnum lifecycleStatusEnum) {
    this.lifecycleStatusEnum = lifecycleStatusEnum;
    return this;
  }

  /**
   * Get lifecycleStatusEnum
   * @return lifecycleStatusEnum
  **/
  @ApiModelProperty(value = "")


  public LifecycleStatusEnumEnum getLifecycleStatusEnum() {
    return lifecycleStatusEnum;
  }

  public void setLifecycleStatusEnum(LifecycleStatusEnumEnum lifecycleStatusEnum) {
    this.lifecycleStatusEnum = lifecycleStatusEnum;
  }

  public PricingLogicAlgorithm name(String name) {
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

  public PricingLogicAlgorithm plaSpecId(String plaSpecId) {
    this.plaSpecId = plaSpecId;
    return this;
  }

  /**
   * id of corresponding PricingLogicAlgorithm specification
   * @return plaSpecId
  **/
  @ApiModelProperty(value = "id of corresponding PricingLogicAlgorithm specification")


  public String getPlaSpecId() {
    return plaSpecId;
  }

  public void setPlaSpecId(String plaSpecId) {
    this.plaSpecId = plaSpecId;
  }

  public PricingLogicAlgorithm uuid(String uuid) {
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

  public PricingLogicAlgorithm validFor(TimePeriod validFor) {
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

  public PricingLogicAlgorithm version(String version) {
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
    PricingLogicAlgorithm pricingLogicAlgorithm = (PricingLogicAlgorithm) o;
    return Objects.equals(this.baseType, pricingLogicAlgorithm.baseType) &&
        Objects.equals(this.schemaLocation, pricingLogicAlgorithm.schemaLocation) &&
        Objects.equals(this.type, pricingLogicAlgorithm.type) &&
        Objects.equals(this.description, pricingLogicAlgorithm.description) &&
        Objects.equals(this.href, pricingLogicAlgorithm.href) &&
        Objects.equals(this.id, pricingLogicAlgorithm.id) &&
        Objects.equals(this.lastUpdate, pricingLogicAlgorithm.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, pricingLogicAlgorithm.lifecycleStatus) &&
        Objects.equals(this.lifecycleStatusEnum, pricingLogicAlgorithm.lifecycleStatusEnum) &&
        Objects.equals(this.name, pricingLogicAlgorithm.name) &&
        Objects.equals(this.plaSpecId, pricingLogicAlgorithm.plaSpecId) &&
        Objects.equals(this.uuid, pricingLogicAlgorithm.uuid) &&
        Objects.equals(this.validFor, pricingLogicAlgorithm.validFor) &&
        Objects.equals(this.version, pricingLogicAlgorithm.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, description, href, id, lastUpdate, lifecycleStatus, lifecycleStatusEnum, name, plaSpecId, uuid, validFor, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingLogicAlgorithm {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    lifecycleStatusEnum: ").append(toIndentedString(lifecycleStatusEnum)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    plaSpecId: ").append(toIndentedString(plaSpecId)).append("\n");
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

