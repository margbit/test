package it.nextworks.tmf_offering_catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "it.nextworks.tmf_offering_catalogue.information_models",
        "it.nextworks.tmf_offering_catalogue.interfaces", "it.nextworks.tmf_offering_catalogue" })
public class WebServer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WebServer.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }
}