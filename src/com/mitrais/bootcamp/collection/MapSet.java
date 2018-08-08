/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Aditia_RS458
 */
public class MapSet {

    enum compass{
        NORTH(1), EAST(2), SOUTH(3), WEST(4);
        
        private int value;
        private compass(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        compass kompas = compass.NORTH;
        System.out.println(kompas.EAST.value);
        System.out.println(kompas.value);
        
        Map<String, Mahasiswa> mhs = new HashMap<>();
        mhs.put("A", new Mahasiswa("Asyakurha Mantap"));
        mhs.put("X", new Mahasiswa("Camat"));
        mhs.put("D", new Mahasiswa("Zudin Mantap"));
        mhs.put("AL", new Mahasiswa("Lisa"));
        mhs.put("B", new Mahasiswa("Rodiah Mantap"));
        mhs.put("C", new Mahasiswa("Khodir"));

        //Sorting Map by key
        Map<String, Mahasiswa> newMhs = mhs.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(newMhs);

        //Sorting Map by value
        newMhs = mhs.entrySet().stream()
                .sorted(Map.Entry.<String, Mahasiswa>comparingByValue(Comparator.comparing(Mahasiswa::getName)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(newMhs);

        //Sorting Set
        Set<String> nim = mhs.keySet();
        Set<String> newNim = nim.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toSet());
        System.out.println(newNim);

        //Filtering Set
        newNim = nim.stream().filter(x -> x.startsWith("A")).collect(Collectors.toSet());
        System.out.println(newNim);

        //Filtering Map
        mhs = mhs.entrySet().stream()
                .filter(x -> {
                    if (x.getValue().getName().endsWith("Mantap")) {
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(mhs);
    }
}

class Mahasiswa {

    String name;

    public Mahasiswa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
