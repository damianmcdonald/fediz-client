package com.github.damianmcdonald.fedizclient.service;

import com.github.damianmcdonald.fedizclient.PropertiesSingleton;
import com.github.damianmcdonald.fedizclient.client.WebClient;
import com.github.damianmcdonald.fedizclient.client.XmlResponse;
import com.github.damianmcdonald.fedizclient.domain.Application;
import com.github.damianmcdonald.fedizclient.domain.TrustedIdp;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;

public class FedizRestApiService {

    private final static String REST_USERNAME = "fediz.rest.url.username";
    private final static String REST_PASSWORD = "fediz.rest.url.password";
    private final static String TRUSTED_IDP_URL = "fediz.rest.url.trustedidp";
    private final static String TRUSTED_APPLICATIONS_URL = "fediz.rest.url.applications";
    private final static String TRUSTED_IDP_TAG_NAME = "fediz.rest.tag.trustedidp";
    private final static String APPLICATIONS_TAG_NAME = "fediz.rest.tag.applications";

    private final PropertiesSingleton propertiesService = PropertiesSingleton.getInstance();

    public Object getRestResponse(FedizRestApi fedizRestApi) {
        final Client client = new WebClient().getWebClient();
        Object response;
        switch (fedizRestApi) {
            case TRUSTED_IDP:
                final String idpResponse = client
                        .target(propertiesService.getProperty(TRUSTED_IDP_URL))
                        .request(MediaType.APPLICATION_XML)
                        .header("Authorization", getCredentials())
                        .get(String.class);
                response = getTrustedIdps(idpResponse);
                break;
            case APPLICATIONS:
                final String appResponse = client
                        .target(propertiesService.getProperty(TRUSTED_APPLICATIONS_URL))
                        .request(MediaType.APPLICATION_XML)
                        .header("Authorization", getCredentials())
                        .get(String.class);
                response = getApplications(appResponse);
                break;
            default:
                throw new IllegalArgumentException(String.format("%s is not a valid Fediz REST API type.", fedizRestApi.toString()));
        }
        return response;
    }

    private String getCredentials() {
        final String usernameAndPassword = String.format("%s:%s", propertiesService.getProperty(REST_USERNAME), propertiesService.getProperty(REST_PASSWORD));
        return "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes() );
    }


    private Set<TrustedIdp> getTrustedIdps(final String xmlResponse) {
        final Set<TrustedIdp> trustedIdps = new HashSet<TrustedIdp>();
        final Document xmlDocument = new XmlResponse().stringToXmlDocument(xmlResponse);
        final NodeList idpNodeList = xmlDocument.getElementsByTagName(propertiesService.getProperty(TRUSTED_IDP_TAG_NAME));
        for(int i = 0; i < idpNodeList.getLength(); i++) {
            final Element elem = (Element) idpNodeList.item(i);
            trustedIdps.add(new TrustedIdp(elem));
        }
        return trustedIdps;
    }

    private Set<Application> getApplications(final String xmlResponse) {
        final Set<Application> applications = new HashSet<Application>();
        final Document xmlDocument = new XmlResponse().stringToXmlDocument(xmlResponse);
        final NodeList idpNodeList = xmlDocument.getElementsByTagName(propertiesService.getProperty(APPLICATIONS_TAG_NAME));
        for(int i = 0; i < idpNodeList.getLength(); i++) {
            final Element elem = (Element) idpNodeList.item(i);
            applications.add(new Application(elem));
        }
        return applications;
    }

}


