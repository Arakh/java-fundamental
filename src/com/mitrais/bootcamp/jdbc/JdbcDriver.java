/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aditia_RS458
 */
public abstract class JdbcDriver{

    private String driver;
    private String url;
    private String user;
    private String pass;
    private Connection conn;

    public JdbcDriver() {
    }

    public JdbcDriver(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public Connection openConnection() {
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException ex) {
                System.out.println("Class jdbc not found : " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Something wrong with sql : " + ex.getMessage());
            }
        }
        return conn;
    }

    public void closedConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Something wrong when closed connection : " + ex.getMessage());
        } finally {
            conn = null;
        }
    }

    public void closedStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error when close statement : " + ex.getMessage());
        }
    }

    public boolean insertOperation(String sql) {
        boolean result = false;
        Statement statement = null;
        try {
            statement = openConnection().createStatement();
            result = statement.execute(sql);
        } catch (SQLException ex) {
            System.out.println("Getting error when insert data : " + ex.getMessage());
        } finally {
            closedStatement(statement);
            closedConnection();
        }
        return result;
    }

    public boolean updateOperation(String sql) {
        boolean result = false;
        Statement statement = null;
        try {
            statement = openConnection().createStatement();
            result = statement.execute(sql);
        } catch (SQLException ex) {
            System.out.println("Getting error when update data : " + ex.getMessage());
        } finally {
            closedStatement(statement);
            closedConnection();
        }
        return result;
    }

    public boolean deleteOperation(String sql) {
        boolean result = false;
        Statement statement = null;
        try {
            statement = openConnection().createStatement();
            result = statement.execute(sql);
        } catch (SQLException ex) {
            System.out.println("Getting error when update data : " + ex.getMessage());
        } finally {
            closedStatement(statement);
            closedConnection();
        }
        return result;
    }
    
    
    public int[] insertBatchOperation(List<String> sql) {
        int[] result = new int[0];
        Statement statement = null;
        try {
            openConnection().setAutoCommit(false);
            statement = openConnection().createStatement();
            for(String s : sql){
                statement.addBatch(s);   
            }
            result = statement.executeBatch();
            openConnection().commit();
        } catch (SQLException ex) {
            System.out.println("Getting error when insert data : " + ex.getMessage());
        } finally {
            closedStatement(statement);
            closedConnection();
        }
        return result;
    }

    public int[] updateBatchOperation(List<String> sql) {
        int[] result = new int[0];
        Statement statement = null;
        try {
            openConnection().setAutoCommit(false);
            statement = openConnection().createStatement();
            for(String s : sql){
                statement.addBatch(s);   
            }
            result = statement.executeBatch();
            openConnection().commit();
        } catch (SQLException ex) {
            System.out.println("Getting error when update data : " + ex.getMessage());
        } finally {
            closedStatement(statement);
            closedConnection();
        }
        return result;
    }

    public int[] deleteBatchOperation(List<String> sql) {
        int[] result = new int[0];
        Statement statement = null;
        try {
            openConnection().setAutoCommit(false);
            statement = openConnection().createStatement();
            for(String s : sql){
                statement.addBatch(s);   
            }
            result = statement.executeBatch();
            openConnection().commit();
        } catch (SQLException ex) {
            System.out.println("Getting error when update data : " + ex.getMessage());
        } finally {
            closedStatement(statement);
            closedConnection();
        }
        return result;
    }

    public List<Map<String, Object>> getData(String sql) {
        List<Map<String, Object>> result = new ArrayList<>();

        Statement statement = null;
        try {
            openConnection().setAutoCommit(false);
            statement = openConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int columSize = rs.getMetaData().getColumnCount();
                for (int i = 0; i < columSize; i++) {
                    Map<String, Object> row = new HashMap<>();
                    row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
                    result.add(row);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error when get data : " + ex.getMessage());
        } finally {
            closedStatement(statement);
            closedConnection();
        }

        return result;
    }
    
    public Map<String, Object> getDatum(String sql) {
        Map<String, Object> result = new HashMap<>();

        Statement statement = null;
        try {
            statement = openConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()) {
                int columSize = rs.getMetaData().getColumnCount();
                for (int i = 0; i < columSize; i++) {
                    result.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error when get data : " + ex.getMessage());
        } finally {
            closedStatement(statement);
            closedConnection();
        }

        return result;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
