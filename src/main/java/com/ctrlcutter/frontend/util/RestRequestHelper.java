package com.ctrlcutter.frontend.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ctrlcutter.frontend.entities.rest.BasicScriptDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestRequestHelper {

    public static final String BASE_URL = "http://localhost:8080/";
    public static final String APPLICATION_TYPE = "application/json";

    public static ResponseEntity<String> makeShortcutRESTRequest(BasicScriptDTO scriptDTO) {

        String json = convertObjectToJSON(scriptDTO);

        return makeGenericRESTRequest("script/basic/", json);
    }

    private static ResponseEntity<String> makeGenericRESTRequest(String endpoint, String body) {

        try {

            Client client = Client.create();
            WebResource webResource = client.resource(BASE_URL + endpoint);
            ClientResponse response = webResource.type(APPLICATION_TYPE).post(ClientResponse.class, body);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            return new ResponseEntity<>(output, HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>("REST Request failed.", HttpStatus.BAD_REQUEST);
        }
    }

    private static String convertObjectToJSON(Object object) {
        String json = null;

        try {
            json = new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

}
