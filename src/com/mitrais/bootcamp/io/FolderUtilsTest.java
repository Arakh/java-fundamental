/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.io;

/**
 *
 * @author Aditia_RS458
 */
public class FolderUtilsTest {

    public static void main(String[] args) {
        System.out.println("All files in project root");
        FolderUtils.printAllPathsInFolder("C:\\Program Files");
        System.out.println("Text files in project root");
        FolderUtils.printPathsInFolder(".",
                p -> p.toString().endsWith(".txt"));

        System.out.println("All files under project root");
        FolderUtils.printAllPathsInTree(".");
        System.out.println("Java files under project root");
        FolderUtils.printPathsInTree(".", p -> p.toString().endsWith(".java"));
    }

}
