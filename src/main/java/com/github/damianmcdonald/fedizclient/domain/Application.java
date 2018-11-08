package com.github.damianmcdonald.fedizclient.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.w3c.dom.Element;

public class Application {

    private final int id;
    private final String realm;
    private final String role;
    private final String serviceDisplayName;
    private final String serviceDescription;
    private final String protocol;
    private final String tokenType;

    public Application(Element elem) {
        this.id = Integer.parseInt(elem.getAttribute("id"));
        this.realm = elem.getElementsByTagName("realm").item(0).getTextContent();
        this.role = elem.getElementsByTagName("role").item(0).getTextContent();
        this.serviceDisplayName = elem.getElementsByTagName("serviceDisplayName").item(0).getTextContent();
        this.serviceDescription = elem.getElementsByTagName("serviceDescription").item(0).getTextContent();
        this.protocol = elem.getElementsByTagName("protocol").item(0).getTextContent();
        this.tokenType = elem.getElementsByTagName("tokenType").item(0).getTextContent();
    }

    @Override
    public String toString() {
        // Generate toString including transient and static fields.
        return ReflectionToStringBuilder.toString(this,
                ToStringStyle.MULTI_LINE_STYLE, true, true);
    }


    public int getId() {
        return id;
    }

    public String getRealm() {
        return realm;
    }

    public String getRole() {
        return role;
    }

    public String getServiceDisplayName() {
        return serviceDisplayName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getTokenType() {
        return tokenType;
    }
}
