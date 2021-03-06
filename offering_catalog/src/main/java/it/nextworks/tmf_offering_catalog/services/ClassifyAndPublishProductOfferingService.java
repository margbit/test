package it.nextworks.tmf_offering_catalog.services;

import it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingStatesEnum;
import it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingStatus;
import it.nextworks.tmf_offering_catalog.repo.ProductOfferingStatusRepository;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
public class ClassifyAndPublishProductOfferingService {

    private static final Logger log = LoggerFactory.getLogger(ClassifyAndPublishProductOfferingService.class);

    private static final String protocol = "http://";

    @Value("${sc_lcm.hostname}")
    private String scLcmHostname;
    @Value("${sc_lcm.port}")
    private String scLcmPort;
    @Value("${sc_lcm.sc_lcm_request_path}")
    private String scLcmRequestPath;

    @Value("${srsd.hostname}")
    private String srsdHostname;
    @Value("${srsd.port}")
    private String srsdPort;
    @Value("${srsd.srsd_request_path}")
    private String srsdRequestPath;

    @Autowired
    private ProductOfferingStatusRepository productOfferingStatusRepository;

    @Async
    public void classifyAndPublish(String catalogId, String cwJson, String pwJson) {
        Optional<ProductOfferingStatus> toClassify = productOfferingStatusRepository.findById(catalogId);
        if(!toClassify.isPresent()) {
            log.error("Product Offering Status for id " + catalogId + " not found in DB.");
            return;
        }

        ProductOfferingStatus productOfferingStatus = toClassify.get();

        if(!classifyProductOffering(catalogId, cwJson)) {
            productOfferingStatus.setStatus(ProductOfferingStatesEnum.CLASSIFICATION_FAILED);
            productOfferingStatusRepository.save(productOfferingStatus);
            return;
        }

        productOfferingStatus.setStatus(ProductOfferingStatesEnum.CLASSIFIED);
        productOfferingStatusRepository.save(productOfferingStatus);

        if(!publicProductOffering(catalogId, pwJson)) {
            productOfferingStatus.setStatus(ProductOfferingStatesEnum.PUBLISHING_FAILED);
            productOfferingStatusRepository.save(productOfferingStatus);
            return;
        }

        productOfferingStatus.setStatus(ProductOfferingStatesEnum.PUBLISHED);
        productOfferingStatusRepository.save(productOfferingStatus);
    }

    private boolean classifyProductOffering(String catalogId, String cwJson) {

        log.info("Classifying Product Offering with id " + catalogId + ".");

        String request = protocol + srsdHostname + ":" + srsdPort + srsdRequestPath;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(request);

        StringEntity stringEntity;
        try {
            stringEntity = new StringEntity(cwJson);
        } catch (UnsupportedEncodingException e) {
            log.error("Cannot encode json body in String Entity: " + e.getMessage());
            return false;
        }

        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            log.error("Cannot send POST request: " + e.getMessage());
            return false;
        }

        if(response.getStatusLine().getStatusCode() != 200) {
            HttpEntity httpEntity = response.getEntity();
            String responseString;

            if(httpEntity != null) {
                try {
                    responseString = EntityUtils.toString(httpEntity, "UTF-8");
                } catch (IOException e) {
                    log.error("Product Offering with id " + catalogId + " not classified; Error description unavailable:"
                            + e.getMessage());
                    return false;
                }
            }
            else
                responseString = "Error description unavailable.";

            log.error("Product Offering with id " + catalogId + " not classified; " + responseString);
            return false;
        }

        log.info("Product Offering with id " + catalogId + " classified.");

        return true;
    }

    private boolean publicProductOffering(String catalogId, String pwJson) {

        log.info("Publishing Product Offering with id " + catalogId + ".");

        String request = protocol + scLcmHostname + ":" + scLcmPort + scLcmRequestPath;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(request);

        StringEntity stringEntity;
        try {
            stringEntity = new StringEntity(pwJson);
        } catch (UnsupportedEncodingException e) {
            log.error("Cannot encode json body in String Entity: " + e.getMessage());
            return false;
        }

        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            log.error("Cannot send POST request: " + e.getMessage());
            return false;
        }

        if(response.getStatusLine().getStatusCode() != 200) {
            HttpEntity httpEntity = response.getEntity();
            String responseString;

            if(httpEntity != null) {
                try {
                    responseString = EntityUtils.toString(httpEntity, "UTF-8");
                } catch (IOException e) {
                    log.error("Product Offering with id " + catalogId + " not published; Error description unavailable:"
                            + e.getMessage());
                    return false;
                }
            }
            else
                responseString = "Error description unavailable.";

            log.error("Product Offering with id " + catalogId + " not published; " + responseString);
            return false;
        }

        log.info("Product Offering with id " + catalogId + " published.");

        return true;
    }
}
