/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.generic;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Aditia_RS458
 */
public class GenericStuff {
    
    public static void main(String[] args) {
        System.out.println("Hallo");
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Charles Sitohang, M.Kom"));
        emp.add(new Employee("Melki Siahaan S.Kom"));
        emp.add(new Employee("Asep Gumasep S.Pd"));
        emp.add(new Employee("Tono Markino S.Pd"));
        
        Filter<Employee, String> filter = new Filter<Employee, String>() {
            @Override
            public boolean isMatched(Employee object, String text) {
                return object.getName().endsWith(text);
            }
        };
        
        List<Employee> newEmp = new FilterList().filterList(emp, filter, "S.Pd");
        newEmp.forEach(System.out::println);
    }
    
}
