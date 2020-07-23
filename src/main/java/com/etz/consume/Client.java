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
public class Client {
 private String meter_name;
 private String meter_address;
 private String meter_number;

    @Override
    public String toString() {
        return "Client{" + "meter_name=" + meter_name + ", meter_address=" + meter_address + ", meter_number=" + meter_number + '}';
    }

    public String getMeter_name() {
        return meter_name;
    }

    public void setMeter_name(String meter_name) {
        this.meter_name = meter_name;
    }

    public String getMeter_address() {
        return meter_address;
    }

    public void setMeter_address(String meter_address) {
        this.meter_address = meter_address;
    }

    public String getMeter_number() {
        return meter_number;
    }

    public void setMeter_number(String meter_number) {
        this.meter_number = meter_number;
    }

    public Client(String meter_name, String meter_address, String meter_number) {
        this.meter_name = meter_name;
        this.meter_address = meter_address;
        this.meter_number = meter_number;
    }

}
