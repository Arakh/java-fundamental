/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.stream;

import java.util.Optional;

/**
 *
 * @author Aditia_RS458
 */
class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getOptionalName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getOptionalAge() {
        return Optional.ofNullable(age);
    }
}

public class OptionClass {

    public static void main(String[] args) {
        //is Present
        Optional<String> optionalPresent = Optional.of("Toto");
        System.out.println("name is present ? " + optionalPresent.isPresent());

        //orElse
        String name = "Chacha";
        System.out.println(Optional.ofNullable(name).orElse("john"));
        System.out.println(Optional.ofNullable(name).orElseGet(() -> "john"));

        //filter
        Optional<Integer> yearOptional = Optional.of(2015);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println("2016 :" + is2016 + "; 2017:" + is2017);

        Optional<Person> optionalPerson = Optional.of(new Person("Maman", 90));
        Optional<Optional<String>> optionalNamePerson = optionalPerson.map(Person::getOptionalName);
        String namePerson = optionalPerson.flatMap(Person::getOptionalName).orElse("");
    }

}
