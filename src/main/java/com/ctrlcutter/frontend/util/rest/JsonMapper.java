package com.ctrlcutter.frontend.util.rest;

import com.ctrlcutter.frontend.util.rest.exception.JsonMappingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

    public static <T> T mapJsonToObject(String sessionJson, Class<T> objectClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            T session = mapper.readValue(sessionJson, objectClass);
            return session;
        } catch (JsonProcessingException e) {
            throw new JsonMappingException("Error while JSON-Mapping during a REST-Request.", e);
        }
    }

    public static String mapObjectToJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String issueJson = mapper.writeValueAsString(o);
            return issueJson;
        } catch (JsonProcessingException e) {
            throw new JsonMappingException("Error while JSON-Mapping during a REST-Request.", e);
        }
    }
}
