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




public class ServiceCatalogDeleteEvent   {
  @JsonProperty("serviceCatalog")
  private ServiceCatalog serviceCatalog = null;

  public ServiceCatalogDeleteEvent serviceCatalog(ServiceCatalog serviceCatalog) {
    this.serviceCatalog = serviceCatalog;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return serviceCatalog
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public ServiceCatalog getServiceCatalog() {
    return serviceCatalog;
  }

  public void setServiceCatalog(ServiceCatalog serviceCatalog) {
    this.serviceCatalog = serviceCatalog;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCatalogDeleteEvent serviceCatalogDeleteEvent = (ServiceCatalogDeleteEvent) o;
    return Objects.equals(this.serviceCatalog, serviceCatalogDeleteEvent.serviceCatalog);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceCatalog);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCatalogDeleteEvent {\n");
    
    sb.append("    serviceCatalog: ").append(toIndentedString(serviceCatalog)).append("\n");
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

