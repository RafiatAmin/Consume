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
public class CustomerResponse {
 private Client client;    
 private Integer code;
 private String message;
 private String time; 

    @Override
    public String toString() {
        return "CustomerResponse{" + "client=" + client + ", code=" + code + ", message=" + message + ", time=" + time + '}';
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CustomerResponse() {
        
    }
}
