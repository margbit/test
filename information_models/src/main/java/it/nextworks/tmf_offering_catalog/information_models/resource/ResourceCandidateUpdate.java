package it.nextworks.tmf_offering_catalog.information_models.resource;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.tmf_offering_catalog.information_models.common.ResourceSpecificationRef;
import it.nextworks.tmf_offering_catalog.information_models.common.TimePeriod;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none. Skipped properties: id,href,id,href
 */
@ApiModel(description = "ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none. Skipped properties: id,href,id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:00:31.056Z")




public class ResourceCandidateUpdate   {
  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("category")
  @Valid
  private List<ResourceCategoryRef> category = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;

  @JsonProperty("lifecycleStatus")
  private String lifecycleStatus = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("resourceSpecification")
  private ResourceSpecificationRef resourceSpecification = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("version")
  private String version = null;

  public ResourceCandidateUpdate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The (immediate) base class type of this REST resource
   * @return baseType
  **/
  @ApiModelProperty(value = "The (immediate) base class type of this REST resource")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ResourceCandidateUpdate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * This field provides a link to the schema describing this REST resource
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "This field provides a link to the schema describing this REST resource")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ResourceCandidateUpdate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Class type of this REST resource
   * @return type
  **/
  @ApiModelProperty(value = "Class type of this REST resource")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceCandidateUpdate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCandidateUpdate addCategoryItem(ResourceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<ResourceCategoryRef>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ResourceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ResourceCategoryRef> category) {
    this.category = category;
  }

  public ResourceCandidateUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of this REST resource
   * @return description
  **/
  @ApiModelProperty(value = "Description of this REST resource")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ResourceCandidateUpdate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update of this REST resource
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date and time of the last update of this REST resource")

  @Valid

  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public ResourceCandidateUpdate lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status of the resource candidate.
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Used to indicate the current lifecycle status of the resource candidate.")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ResourceCandidateUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name given to this REST resource
   * @return name
  **/
  @ApiModelProperty(value = "Name given to this REST resource")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceCandidateUpdate resourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  /**
   * Get resourceSpecification
   * @return resourceSpecification
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ResourceSpecificationRef getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ResourceCandidateUpdate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which this REST resource is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which this REST resource is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ResourceCandidateUpdate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * the version of resource candidate
   * @return version
  **/
  @ApiModelProperty(value = "the version of resource candidate")


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
    ResourceCandidateUpdate resourceCandidateUpdate = (ResourceCandidateUpdate) o;
    return Objects.equals(this.baseType, resourceCandidateUpdate.baseType) &&
        Objects.equals(this.schemaLocation, resourceCandidateUpdate.schemaLocation) &&
        Objects.equals(this.type, resourceCandidateUpdate.type) &&
        Objects.equals(this.category, resourceCandidateUpdate.category) &&
        Objects.equals(this.description, resourceCandidateUpdate.description) &&
        Objects.equals(this.lastUpdate, resourceCandidateUpdate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceCandidateUpdate.lifecycleStatus) &&
        Objects.equals(this.name, resourceCandidateUpdate.name) &&
        Objects.equals(this.resourceSpecification, resourceCandidateUpdate.resourceSpecification) &&
        Objects.equals(this.validFor, resourceCandidateUpdate.validFor) &&
        Objects.equals(this.version, resourceCandidateUpdate.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, category, description, lastUpdate, lifecycleStatus, name, resourceSpecification, validFor, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCandidateUpdate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
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

