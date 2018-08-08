/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.collection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Aditia_RS458
 */
public class ListAndLinked {

    public static void main(String[] args) {
        System.out.println(LocalTime.now().getNano());
//        ListAndLinked<String> fruits = new ArrayList;
//        List<String> fruits = new ArrayList<>();
        LinkedList<String> fruits = new LinkedList<>();

        fruits.add("ElderBerry");
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Date");
        fruits.add("Cherry");
        fruits.add("Delima");
        fruits.sort(String.CASE_INSENSITIVE_ORDER);
        
        //FOREACH USING lambda
        fruits.forEach((k) -> {
            System.out.println("This is the Key : " + k);
        });
        
        System.out.println(LocalTime.now().getNano());
        
        LinkedList<Employee> emp = new LinkedList<>();
        emp.add(new Employee("Ibrahim", "589623214"));
        emp.add(new Employee("Maman", "589623214"));
        emp.add(new Employee("Poti", "589623214"));
        emp.add(new Employee("Amila", "589623214"));
        emp.add(new Employee("Amila", "589623213"));
        
        //SORTING SINGLE FIELD
        emp.sort(Comparator.comparing(Employee::getName).reversed());
        emp.forEach(System.out::println);
        
        //SORTING MULTI FIELD
        emp.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getNIK));
        emp.forEach(System.out::println);
        
        //FILTERING USING STREAM
        System.out.println("---------------------------------------------------------------");
        List<Employee> newEmp = emp.stream().filter(e -> e.getName().startsWith("Amalia")).collect(Collectors.toList());
        emp.forEach(System.out::println);
        
        Employee singEmp = emp.stream()
                .filter(e -> e.getName().startsWith("Amila"))
                .findAny()
                .orElse(null);
        System.out.println(singEmp);
    }

}

class Employee{
    
    String name;
    String nik;
    
    public Employee(String name, String nik){
        this.name = name;
        this.nik = nik;
    }
    
    public String getNIK(){
        return nik;
    }
    
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name+" - "+nik;
    }
}

interface Filter<T, E> {

    public boolean isMatched(T object, E text);
}

class FilterList<E> {

    public <T> List filterList(List<T> originalList, Filter filter, E text) {
        List<T> filterList = new ArrayList<T>();
        for (T object : originalList) {
            if (filter.isMatched(object, text)) {
                filterList.add(object);
            } else {
                continue;
            }
        }
        return filterList;
    }
}
  
