package it.nextworks.tmf_offering_catalog.information_models.service;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * The event data structure
 */
@ApiModel(description = "The event data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:03:19.238Z")




public class ServiceSpecificationDeleteEvent   {
  @JsonProperty("serviceSpecification")
  private ServiceSpecification serviceSpecification = null;

  public ServiceSpecificationDeleteEvent serviceSpecification(ServiceSpecification serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return serviceSpecification
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public ServiceSpecification getServiceSpecification() {
    return serviceSpecification;
  }

  public void setServiceSpecification(ServiceSpecification serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceSpecificationDeleteEvent serviceSpecificationDeleteEvent = (ServiceSpecificationDeleteEvent) o;
    return Objects.equals(this.serviceSpecification, serviceSpecificationDeleteEvent.serviceSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceSpecification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecificationDeleteEvent {\n");
    
    sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
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

