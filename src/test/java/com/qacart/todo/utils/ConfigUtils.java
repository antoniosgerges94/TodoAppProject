package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {

    private Properties properties;


    private ConfigUtils(){
        String env = System.getProperty("env","production");
        switch (env){
            case "production":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/properties.production");
                break;
                case "local":
                    properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/properties.local");
                    break;
                    default:
                        throw new RuntimeException("Environment not found");
        }
    }

    private static final ConfigUtils configUtils = new ConfigUtils();

    public static ConfigUtils getInstance() {
        return configUtils;
    }


    public String getBaseUrl(){
       String prop = properties.getProperty("baseUrl");
       if(prop != null)
           return prop;
        throw new RuntimeException("baseUrl property is null");
    }

    public String getEmail(){
        String prop = properties.getProperty("email");
        if(prop != null)
            return prop;
        throw new RuntimeException("email property is null");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null)
            return prop;
        throw new RuntimeException("password property is null");
    }
}
