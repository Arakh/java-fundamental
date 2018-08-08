/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aditia_RS458
 * 
 * Approach One : Separate class that implements Runnable
 * 
 * Advantages
– Loose coupling
• Can change pieces independently
• Can reuse Runnable class in more than one application
– Passing arguments
• If you want different threads to do different things, you pass args to constructor, which stores
them in instance variables that run method uses
– Little danger of race conditions
• You usually use this approach when there is no data shared among threads, so no need to
synchronize.
• Disadvantages
– Hard to access main app
• If you want to call methods in main app, you must
– Pass reference to main app to constructor, which stores it
– Make methods in main app be public
 */
public class App1{
    public App1(){
        ExecutorService tasklist = Executors.newFixedThreadPool(3);
        tasklist.execute(new Counter(this, 5));
        tasklist.execute(new Counter(this, 4));
        tasklist.execute(new Counter(this, 9));
        tasklist.execute(new Counter(this, 7));
        tasklist.shutdown();
        
    }
    
    public void pause(double second){
        try {
            Thread.sleep(Math.round(1000 * second));
        } catch (InterruptedException ex) {
            System.out.println("Error when pause : "+ex.getMessage());
        }
    }
}
