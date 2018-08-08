/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.lambda;

import java.util.Arrays;

/**
 *
 * @author Aditia_RS458
 */
interface Vehicle {

    String getBrand();

    String speedUp();

    String slowDown();

    default String turnAlarmOn() {
        return "Vehicle alarm turn on";
    }

    default String turnAlarmOff() {
        return "Vehicle alarm turn off";
    }

}

interface Alarm {
    
    default String turnAlarmOn() {
        return "Turning the alarm on.";
    }

    default String turnAlarmOff() {
        return "Turning the alarm off.";
    }
}

class Car implements Vehicle, Alarm {

    private String brand;

    Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down";
    }

    @Override
    public String turnAlarmOff() {
        return Alarm.super.turnAlarmOff()+" "+Vehicle.super.turnAlarmOff();
    }

    @Override
    public String turnAlarmOn() {
        return Alarm.super.turnAlarmOn()+" "+Vehicle.super.turnAlarmOn();
    }

    
}

public class DefaultInterface {

    public static void main(String[] args) {
        Vehicle car = new Car("BMW");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());
    }
}
