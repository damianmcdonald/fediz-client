package com.github.damianmcdonald.fedizclient.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.w3c.dom.Element;

public class TrustedIdp {

    private final int id;
    private final String realm;
    private final String url;
    private final String name;
    private final String description;
    private final String protocol;
    private final String trustType;
    private final String certificate;
    private final String federationType;
    private final String cacheTokens;
    // private final List<String> parameters;

    public TrustedIdp(Element elem) {
        this.id = Integer.parseInt(elem.getAttribute("id"));
        this.realm = elem.getElementsByTagName("realm").item(0).getTextContent();
        this.url = elem.getElementsByTagName("url").item(0).getTextContent();
        this.name = elem.getElementsByTagName("name").item(0).getTextContent();
        this.description = elem.getElementsByTagName("description").item(0).getTextContent();
        this.protocol = elem.getElementsByTagName("protocol").item(0).getTextContent();
        this.trustType = elem.getElementsByTagName("trustType").item(0).getTextContent();
        this.certificate = elem.getElementsByTagName("certificate").item(0).getTextContent();
        this.federationType = elem.getElementsByTagName("federationType").item(0).getTextContent();
        this.cacheTokens = elem.getElementsByTagName("cacheTokens").item(0).getTextContent();
        // TODO : Add parameters
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

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getTrustType() {
        return trustType;
    }

    public String getCertificate() {
        return certificate;
    }

    public String getFederationType() {
        return federationType;
    }

    public String getCacheTokens() {
        return cacheTokens;
    }

}
