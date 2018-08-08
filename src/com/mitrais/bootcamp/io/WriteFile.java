/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Aditia_RS458
 */
public class WriteFile {
    public static void main(String[] args) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("D:\\test.txt"))){
            for(int i=0; i<100; i++){
                writer.write(Math.random()+" for this time");
                writer.newLine();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
