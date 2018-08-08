/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.jdbc;

import com.mysql.jdbc.Connection;

/**
 *
 * @author Aditia_RS458
 */
public class MySqlDriver extends JdbcDriver{
   
    private MySqlDriver mysql = new MySqlDriver();
    
    public MySqlDriver(){
        super.setDriver("com.mysql.jdbc.Driver");
        super.setUrl("jdbc:mysql://localhost:3306/bootcamp");
        super.setUser("root");
        super.setPass("");
    }
    
   
    
}
