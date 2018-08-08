/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.designpattern;

/**
 *
 * @author Aditia_RS458
 */
abstract class Smartphone {

    protected String ram;
    private String os;
    protected String batteryCapacity;
    protected String cpu;

    private String getOperatingSystem() {
        return os;
    }

    public String getRAM() {
        return ram;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getCPU() {
        return cpu;
    }

    @Override
    public String toString() {
        return String.format("RAM : %s\nBattery Capacity : %s\nCPU : %s \n",
                getRAM(),
                getBatteryCapacity(),
                getCPU());
    }
}

class Android extends Smartphone {
    public Android(String ram, String batteryCapacity, String cpu) {
        this.ram = ram;
        this.batteryCapacity = batteryCapacity;
        this.cpu = cpu;
    }
}

class Iphone extends Smartphone {
    public Iphone(String ram, String batteryCapacity, String cpu){
        this.ram = ram;
        this.batteryCapacity = batteryCapacity;
        this.cpu = cpu;
    }
}

class SmartphoneFactory{
    public static Smartphone getSmartphone(String os, String ram, String batteryCapacity, String cpu){
        if("ANDROID".equalsIgnoreCase(os)){
            return new Android(ram, batteryCapacity, cpu);
        }else if("IPHONE".equalsIgnoreCase(os)){
            return new Iphone(ram, batteryCapacity, cpu);
        }else{
            return null;
        }
            
    } 
}

public class Factorization {
    public static void main(String[] args) {
        Smartphone android = SmartphoneFactory.getSmartphone("android", "2 GB", "5000 MAh", "Quad Core");
        Smartphone iPhone = SmartphoneFactory.getSmartphone("iPhone", "1 GB", "3000 MAh", "Dual Core");
        
        System.out.println("Android\n"+android);
        System.out.println("iPhone\n"+iPhone);
    }
}
