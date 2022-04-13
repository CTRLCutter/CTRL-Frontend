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
import com.ctrlcutter.frontend.dtos.SessionDTO;
import com.ctrlcutter.frontend.dtos.SessionUserDTO;
import com.ctrlcutter.frontend.entities.rest.BasicScriptDTO;
import com.ctrlcutter.frontend.util.rest.exception.APIRequestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestRequestHelper {

    public static final String BASE_URL = "http://localhost:8080/";
    public static final String APPLICATION_TYPE = "application/json";
    private static final String API_USERNAME = "ctrlcutter";
    private static final String API_PASSWORD = "test123password456sick789";

    public static SessionDTO registerUser(RegistrationUserDTO user) {
        HttpResponse<String> response = executeModificationRequestWithEntity(BASE_URL + "customer/signup/", user);
        SessionDTO session = JsonMapper.mapJsonToObject(response.body(), SessionDTO.class);
        return session;
    }

    public static SessionDTO loginUser(LoginUserDTO user) {
        HttpResponse<String> response = executeModificationRequestWithEntity(BASE_URL + "customer/login/", user);
        SessionDTO session = JsonMapper.mapJsonToObject(response.body(), SessionDTO.class);
        return session;
    }

    public static SessionUserDTO retrieveUserInformation(String sessionKey) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder(URI.create(BASE_URL + "customer/customerData")).header("content-type", APPLICATION_TYPE)
                .header("sessionkey", sessionKey).header("Authorization", generateBasicAuthHeaderValue()).GET().build();

        try {
            HttpResponse<String> response = client.send(req, BodyHandlers.ofString());
            String responseBody = response.body();

            ObjectMapper mapper = new ObjectMapper();
            SessionUserDTO userInfo = mapper.readValue(responseBody, SessionUserDTO.class);

            return userInfo;
        } catch (IOException | InterruptedException e) {
            throw new APIRequestException("Request execution of client during REST-API call failed.", e);
        }
    }

    public static ResponseEntity<String> makeShortcutRESTRequest(BasicScriptDTO scriptDTO) {
        String json = JsonMapper.mapObjectToJson(scriptDTO);
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

    private static HttpResponse<String> executeModificationRequestWithEntity(String uri, Object requestObject) {
        String objectJson = JsonMapper.mapObjectToJson(requestObject);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder(URI.create(uri)).header("content-type", APPLICATION_TYPE)
                .header("Authorization", generateBasicAuthHeaderValue()).POST(HttpRequest.BodyPublishers.ofString(objectJson)).build();

        try {
            return client.send(req, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new APIRequestException("Request execution of client during REST-API call failed.", e);
        }
    }

    private static String generateBasicAuthHeaderValue() {
        Encoder base64Encoder = Base64.getEncoder();
        String unencodedAuthentication = API_USERNAME + ":" + API_PASSWORD;
        byte[] unencodedAuthenticationBytes = unencodedAuthentication.getBytes();
        byte[] encodedAuthenticationBytes = base64Encoder.encode(unencodedAuthenticationBytes);

        String headerBase = "Basic ";
        String headerValue = new String(encodedAuthenticationBytes);

        return headerBase + headerValue;
    }
}
