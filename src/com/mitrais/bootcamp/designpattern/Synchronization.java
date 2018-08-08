/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.designpattern;

import com.sun.webkit.ThemeClient;

/**
 *
 * @author Aditia_RS458
 */
class Table {
    void printTable(int n) {//method not synchronized  
        for (int i = 1; i <= 5; i++) {
            System.out.println(n+" - "+(n * i));
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    synchronized void printTableSynchronizely(int n) {//method not synchronized  
        for (int i = 1; i <= 5; i++) {
            System.out.println(n+" - "+(n * i));
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class Thread1 extends Thread{
    Table t;
    boolean isSynchronized;
    
    public Thread1(Table t, boolean isSynchronized) {
        this.t = t;
        this.isSynchronized = isSynchronized;
    }
    
    public void run(){
        if(isSynchronized){
            t.printTableSynchronizely(3);
        }else{
            t.printTable(5);   
        }
    }
    
}


class Thread2 extends Thread{
    Table t;
    boolean isSynchronized;
    
    public Thread2(Table t, boolean isSynchronized) {
        this.t = t;
        this.isSynchronized = isSynchronized;
    }
    
    public void run(){
        if(isSynchronized){
            t.printTableSynchronizely(9);
        }else{
            t.printTable(100);   
        }
    }
    
}

public class Synchronization {
    public static void main(String[] args) {
        Table tbl = new Table();
        Thread1 t1;
        Thread2 t2;
        
        /*async*/
        t1 = new Thread1(tbl, false);
        t2 = new Thread2(tbl, false);
        
        /*sync*/
        Thread1 t11 = new Thread1(tbl, true);
        Thread2 t22 = new Thread2(tbl, true);
        
        t1.start();
        t11.start();
        t2.start();
        t22.start();
    }
}
