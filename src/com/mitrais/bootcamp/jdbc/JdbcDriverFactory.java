/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.jdbc;

/**
 *
 * @author Aditia_RS458
 */
public class JdbcDriverFactory {
    public static enum DRIVER_TYPE {MYSQL}; 
    
    public static JdbcDriver getDriver(DRIVER_TYPE driverType){
        if(driverType.equals(DRIVER_TYPE.MYSQL)){
            return new MySqlDriver();
        }
        return new MySqlDriver();
    }
}
