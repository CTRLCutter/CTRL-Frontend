package com.ctrlcutter.frontend.util.rest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ctrlcutter.frontend.dtos.LoginUserDTO;
import com.ctrlcutter.frontend.dtos.RegistrationUserDTO;
import com.ctrlcutter.frontend.entities.rest.BasicScriptDTO;
import com.ctrlcutter.frontend.util.rest.exception.APIRequestException;
import com.ctrlcutter.frontend.util.rest.exception.JsonMappingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestRequestHelper {

    public static final String BASE_URL = "http://localhost:8080/";
    public static final String APPLICATION_TYPE = "application/json";
    private static final String API_USERNAME = "ctrlcutter";
    private static final String API_PASSWORD = "test123password456sick789";

    public static String registerUser(RegistrationUserDTO user) {
        HttpResponse<String> response = executeModificationRequestWithEntity(BASE_URL + "customer/signup/", user);
        return response.body();
    }

    public static String loginUser(LoginUserDTO user) {
        HttpResponse<String> response = executeModificationRequestWithEntity(BASE_URL + "customer/login/", user);
        return response.body();
    }

    public static ResponseEntity<String> makeShortcutRESTRequest(BasicScriptDTO scriptDTO) {
        String json = mapObjectToJson(scriptDTO);
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

    private static String mapObjectToJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String issueJson = mapper.writeValueAsString(o);
            return issueJson;
        } catch (JsonProcessingException e) {
            throw new JsonMappingException("Error while JSON-Mapping during a REST-Request.", e);
        }
    }

    private static HttpResponse<String> executeModificationRequestWithEntity(String uri, Object requestObject) {
        String objectJson = mapObjectToJson(requestObject);

        HttpClient client = HttpClient.newHttpClient();
        Encoder base64Encoder = Base64.getEncoder();
        String unencodedAuthentication = API_USERNAME + ":" + API_PASSWORD;

        HttpRequest req = HttpRequest.newBuilder(URI.create(uri)).header("content-type", APPLICATION_TYPE)
                .header("Authorization", "Basic " + new String(base64Encoder.encode(unencodedAuthentication.getBytes())))
                .POST(HttpRequest.BodyPublishers.ofString(objectJson)).build();

        try {
            return client.send(req, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new APIRequestException("Request execution of client during REST-API call failed.", e);
        }
    }
}
