/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Aditia_RS458
 */
public class BuildingBlockPredicate {

    public static void main(String[] args) {

        //First Variation
        List<Apple> apples = Arrays.asList(new Apple("green", 120.0), new Apple("red", 110.0),
                new Apple("brown", 150.0), new Apple("green", 160.0), new Apple("red", 122.0));
        ApplePredicates.filterApples(apples, ApplePredicates.isWeightAbove150()).forEach(System.out::println);

        //Second Variation
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1, e2, e3, e4, e5, e6, e7, e8, e9, e10}));

        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultMale()));

        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultFemale()));

        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(35)));

        //Employees other than above collection of "isAgeMoreThan(35)" can be get using negate()
        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(35).negate()));
        
        //Third variation
        Predicate<Employee> isMale = em -> em.getGender().equalsIgnoreCase("M");
        System.out.println(String.format("Is %s male ? %s", e8.getFirstName() ,isMale.test(e8)));
    }
}

class Apple {

    private String color;
    private Double weight;

    public Apple(String c, Double w) {
        this.color = c;
        this.weight = w;
    }

    @Override
    public String toString() {
        return "Apple{color:" + this.getColor() + ",weight:" + this.getWeight() + "}";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}

class ApplePredicates {

    public static Predicate<Apple> isWeightAbove150() {
        return apple -> apple.getWeight() >= 150;
    }

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        return apples.stream().filter(predicate).collect(Collectors.toList());
    }
}

class Employee {

    public Employee(Integer id, Integer age, String gender, String fName, String lName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    //Please generate Getter and Setters
    @Override
    public String toString() {
        return this.id.toString() + " - " + this.age.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class EmployeePredicates {

    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }

    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
    }
}
