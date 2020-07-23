/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etz.consume;

/**
 *
 * @author rafiat.aminu
 */
public class TokenRequest {
private String username;
private String password;


    @Override
    public String toString() {
        return "TokenRequest{" + "username=" + username + ", password=" + password + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TokenRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}