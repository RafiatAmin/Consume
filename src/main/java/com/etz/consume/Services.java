/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etz.consume;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author rafiat.aminu
 */
public class Services {

    private static Object username;
    private static Object password;

    public static void main(String args[]) throws MalformedURLException, IOException {
        Services con = new Services();
        con.getCustomer("123");
    }

    public String generateToken() throws IOException {

        String tokenCode = "";

        String username = "9f7fdce52d1249d_demo";
        String password = "v7^Ldx0@Bp=mX6t9vQ5z1&";

        TokenRequest tok = new TokenRequest(username, password);

        Gson gson = new Gson();
        String jsonParameter = gson.toJson(tok);

        URL url = new URL("https://api.adroitsuite.com.ng/core/auth/token/demo");
        //open connection
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //set the request method
        con.setRequestMethod("POST");
        //set request header parameter
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("content-type", "application/Json; utf-8");
        //set response format type
        con.setRequestProperty("Accept", "application/Json");
        //to send request content
        con.setDoOutput(true);
        //create the request body
        //  String jsonParameter = "{\"username\": \"9f7fdce52d1249d_demo\", \"password\": \"v7^Ldx0@Bp=mX6t9vQ5z1&\"}";

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonParameter.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        //Read the response from input stream
        StringBuilder response;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            response = new StringBuilder();
            String responseLine = " ";
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            TokenResponse res = gson.fromJson(response.toString(), TokenResponse.class);
            tokenCode = res.getToken();
        }

        return tokenCode;
    }

    public String getCustomer(String meter) throws IOException {
        String accessCode = generateToken();

        System.out.println("This is access code " + accessCode);
        URL url = new URL("https://api.adroitsuite.com.ng/core/energy/jos/prepaid/demo/customer/" + meter);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Authorization", "Bearer " + accessCode);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/Json; utf-8");
        con.setRequestProperty("Accept", "application/Json");
        Gson gson = new Gson();
        // String jsonParameter = gson.toJson(res);

        StringBuilder result;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            result = new StringBuilder();
            String responseLine = "";
            while ((responseLine = br.readLine()) != null) {
                result.append(responseLine);
            }
            System.out.println(result.toString());
            CustomerResponse res = gson.fromJson(result.toString(), CustomerResponse.class );
            res.getClient();
            res.getCode();
            res.getMessage();
            res.getTime();
            System.out.println(res.getClient());
            System.out.println(res.getCode());
            System.out.println(res.getMessage());
            System.out.println(res.getTime());
        }
        return result.toString();
    }

}
