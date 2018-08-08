/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;

/**
 *
 * @author Aditia_RS458
 */
public class LocalDateExample {

    public static void main(String[] args) {
        //        Wrong DATE
//        LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
//        System.out.println("Invalid date : "+feb29_2014);
        LocalDate birthday = LocalDate.of(1992, Month.MAY, 10);
        LocalDate current = LocalDate.now();
        System.out.println(current.plusDays(10));
        System.out.println(current.format(DateTimeFormatter.ofPattern("dd MM yyyy")));
        Period period = birthday.until(current);
        System.out.println("My age : "+period.getYears());
        
        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST=" + todayKolkata);

        //Getting date from the base date i.e 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date= " + dateFromBase);

        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014=" + hundredDay2014);

    }
}
