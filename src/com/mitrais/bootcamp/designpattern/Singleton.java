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
public class Singleton {
   private static Singleton instance;
    
   public static Singleton INSTANCE(){
       if(instance == null){
           instance = new Singleton();
       }
       
       return instance;
   }
}
