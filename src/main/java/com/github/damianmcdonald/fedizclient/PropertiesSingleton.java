package com.github.damianmcdonald.fedizclient;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesSingleton {

    private static PropertiesSingleton instance;
    private final static Properties props = new Properties();

    private PropertiesSingleton() {
    }

    public static synchronized PropertiesSingleton getInstance() {
        if (instance == null) {
            synchronized (PropertiesSingleton.class) {
                if (instance == null) {
                    instance = new PropertiesSingleton();
                    try {
                        final ClassLoader classLoader = PropertiesSingleton.class.getClassLoader();
                        props.load(new FileInputStream(new File(classLoader.getResource("config.properties").getFile())));
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
        return instance;
    }

    public String getProperty(final String key) {
        return props.getProperty(key);
    }

}
