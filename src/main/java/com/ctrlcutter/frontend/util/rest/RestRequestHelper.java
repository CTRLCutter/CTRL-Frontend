package com.ctrlcutter.frontend.util.rest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ctrlcutter.frontend.dtos.BasicScriptDTO;
import com.ctrlcutter.frontend.dtos.HotstringDTO;
import com.ctrlcutter.frontend.dtos.LoginUserDTO;
import com.ctrlcutter.frontend.dtos.PredefinedScriptDTO;
import com.ctrlcutter.frontend.dtos.RegistrationUserDTO;
import com.ctrlcutter.frontend.dtos.SessionDTO;
import com.ctrlcutter.frontend.dtos.SessionUserDTO;
import com.ctrlcutter.frontend.entities.rest.BackupScriptDTO;
import com.ctrlcutter.frontend.util.rest.exception.APIRequestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestRequestHelper {

    public static final String BASE_URL = "http://localhost:8080/";
    public static final String WEB_URL = "http://localhost:8089/";
    public static final String APPLICATION_TYPE = "application/json";
    private static final String API_USERNAME = "ctrlcutter";
    private static final String API_PASSWORD = "test123password456sick789";

    public static SessionDTO registerUser(RegistrationUserDTO user) {
        HttpResponse<String> response = executeModificationRequestWithEntity(WEB_URL + "customer/signup/", user);
        SessionDTO session = JsonMapper.mapJsonToObject(response.body(), SessionDTO.class);
        return session;
    }

    public static SessionDTO loginUser(LoginUserDTO user) {
        HttpResponse<String> response = executeModificationRequestWithEntity(WEB_URL + "customer/login/", user);
        SessionDTO session = JsonMapper.mapJsonToObject(response.body(), SessionDTO.class);
        return session;
    }

    public static List<BasicScriptDTO> getAllScripts() {
        String responseJson = executeGetRequest(BASE_URL, "storage/allBasic");
        ObjectMapper mapper = new ObjectMapper();

        try {
            if (responseJson.equals("")) {
                return new ArrayList<>();
            }
            List<BasicScriptDTO> list = mapper.readValue(responseJson, TypeFactory.defaultInstance().constructCollectionType(List.class, BasicScriptDTO.class));
            return list;
        } catch (JsonProcessingException e) {
            throw new APIRequestException("Request execution of client during REST-API call failed.", e);
        }
    }

    public static List<PredefinedScriptDTO> getAllPredefinedScripts() {
        String responseJson = executeGetRequest(BASE_URL, "storage/allPreDefined");
        ObjectMapper mapper = new ObjectMapper();

        try {
            if (responseJson.equals("")) {
                return new ArrayList<>();
            }
            List<PredefinedScriptDTO> list =
                    mapper.readValue(responseJson, TypeFactory.defaultInstance().constructCollectionType(List.class, PredefinedScriptDTO.class));
            return list;
        } catch (JsonProcessingException e) {
            throw new APIRequestException("Request execution of client during REST-API call failed.", e);
        }
    }

    public static List<HotstringDTO> getAllHotstrings() {
        String responseJson = executeGetRequest(BASE_URL, "storage/allHotstring");
        ObjectMapper mapper = new ObjectMapper();

        try {

            if (responseJson.equals("")) {
                return new ArrayList<>();
            }

            List<HotstringDTO> list = mapper.readValue(responseJson, TypeFactory.defaultInstance().constructCollectionType(List.class, HotstringDTO.class));
            return list;
        } catch (JsonProcessingException e) {
            throw new APIRequestException("Request execution of client during REST-API call failed.", e);
        }
    }

    public static SessionUserDTO retrieveUserInformation(String sessionKey) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder(URI.create(WEB_URL + "customer/customerData")).header("content-type", APPLICATION_TYPE)
                .header("sessionkey", sessionKey).header("Authorization", generateBasicAuthHeaderValue()).GET().build();

        try {
            HttpResponse<String> response = client.send(req, BodyHandlers.ofString());
            SessionUserDTO userInfo = JsonMapper.mapJsonToObject(response.body(), SessionUserDTO.class);
            return userInfo;
        } catch (IOException | InterruptedException e) {
            throw new APIRequestException("Request execution of client during REST-API call failed.", e);
        }
    }

    public static ResponseEntity<String> makeShortcutRESTRequest(com.ctrlcutter.frontend.entities.rest.BasicScriptDTO scriptDTO) {
        String json = JsonMapper.mapObjectToJson(scriptDTO);
        return makeGenericRESTRequest("script/basic/", json);
    }

    public static ResponseEntity<String> editBasicScript(com.ctrlcutter.frontend.entities.rest.BasicScriptDTO scriptDTO, String id) {
        String json = JsonMapper.mapObjectToJson(scriptDTO);
        return makeGenericPutRequest("edit/basicScript/", json, id);
    }

    public static boolean backupScripts(String sessionKey, boolean saveAll) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req =
                HttpRequest.newBuilder(URI.create(BASE_URL + "storage/backupToWeb?saveAll=" + String.valueOf(saveAll))).header("content-type", APPLICATION_TYPE)
                        .header("Authorization", generateBasicAuthHeaderValue()).header("sessionkey", sessionKey).POST(BodyPublishers.noBody()).build();
        try {
            HttpResponse<String> response = client.send(req, BodyHandlers.ofString());
            if (response.statusCode() == 404) {
                return false;
            }

            return true;
        } catch (IOException | InterruptedException e) {
            System.err.println("Request execution of client during REST-API call failed." + System.lineSeparator() + e.toString());
            return false;
        }
    }

    public static List<BackupScriptDTO> retrieveBackup(String sessionKey) {
        String responseJson = executeGetRequestWithSessionKey(WEB_URL, "scripts/getAll", sessionKey);
        ObjectMapper mapper = new ObjectMapper();

        try {
            if (responseJson.equals("")) {
                return new ArrayList<>();
            }

            List<BackupScriptDTO> list =
                    mapper.readValue(responseJson, TypeFactory.defaultInstance().constructCollectionType(List.class, BackupScriptDTO.class));
            return list;
        } catch (JsonProcessingException e) {
            throw new APIRequestException("Request execution of client during REST-API call failed.", e);
        }
    }

    private static String executeGetRequest(String baseUrl, String endpoint) {
        HttpRequest req = HttpRequest.newBuilder(URI.create(baseUrl + endpoint)).header("content-type", APPLICATION_TYPE)
                .header("Authorization", generateBasicAuthHeaderValue()).GET().build();

        return sendGetRequest(req);
    }

    private static String executeGetRequestWithSessionKey(String baseUrl, String endpoint, String sessionKey) {
        HttpRequest req = HttpRequest.newBuilder(URI.create(baseUrl + endpoint)).header("content-type", APPLICATION_TYPE)
                .header("Authorization", generateBasicAuthHeaderValue()).header("sessionkey", sessionKey).GET().build();

        return sendGetRequest(req);
    }

    private static String sendGetRequest(HttpRequest req) {
        String responseJson = "";
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse<String> response = client.send(req, BodyHandlers.ofString());
            responseJson = response.body();

            if (response.statusCode() == 404) {
                return "";
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Request execution of client during REST-API call failed." + System.lineSeparator() + e.toString());
        }

        return responseJson;
    }

    private static ResponseEntity<String> makeGenericPutRequest(String endpoint, String body, String id) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(BASE_URL + endpoint + "?id=" + id);
            ClientResponse response = webResource.type(APPLICATION_TYPE).put(ClientResponse.class, body);

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
