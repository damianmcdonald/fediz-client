package com.github.damianmcdonald.fedizclient.client;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XmlResponse {

    public Document stringToXmlDocument(final String xml) {
        try {
            final DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            final Document doc = docBuilder.parse(new InputSource(new StringReader(xml)));
            // normalize text representation
            doc.getDocumentElement().normalize();
            return doc;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
