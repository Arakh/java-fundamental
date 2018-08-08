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
interface IBehaviour {

    public int moveCommand();
}

class AgressiveBehaviour implements IBehaviour {

    @Override
    public int moveCommand() {
        System.out.println("\tAgressive Behaviour : If find another robot attack it!");
        return 1;
    }

}

class DefensiveBehaviour implements IBehaviour {

    @Override
    public int moveCommand() {
        System.out.println("\tDefensive Behaviour : If find another robot run!");
        return -1;
    }

}

class NormalBehaviour implements IBehaviour {

    @Override
    public int moveCommand() {
        System.out.println("\tNormal Behaviour : If find another robot ignore!");
        return 0;
    }

}

class Robot {

    private String name;
    private IBehaviour behaviour;

    public Robot(String name) {
        this.name = name;
    }

    public IBehaviour getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(IBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println(this.name + " :Based on current position, the behaviour object decide the next move :");
        int command = behaviour.moveCommand();
        System.out.println("\tThe result returned by behaviour object "
                + "is sent to the movement mechanisms "
                + " for the robot '" + this.name + "'");
    }
}

public class Strategization {

    public static void main(String[] args) {
        Robot r1 = new Robot("Gundam");
        Robot r2 = new Robot("Ultraman");
        Robot r3 = new Robot("Power Ranger");
        
        r1.setBehaviour(new AgressiveBehaviour());
        r2.setBehaviour(new NormalBehaviour());
        r3.setBehaviour(new DefensiveBehaviour());

        r1.move();
        r2.move();
        r3.move();
    }

}
