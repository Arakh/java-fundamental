/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author Aditia_RS458
 */

public class ReadFile {

    public static Predicate<String> isPalindrome() {
        return keyword -> {
            boolean result = keyword.length() > 1;
            int length = keyword.length();
            int middle = length / 2;

            for (int i = 0; i < middle && result; i++) {
                result = keyword.charAt(i) == keyword.charAt(length - 1 - i);
            }

            return result;
        };
    }
    
    public static void main(String[] args) {
        //Stream of file
//        Path p1 = Paths.get("D:\\Downloads\\Document\\cc.txt");
//        Path p1 = Paths.get("D:\\Classified.txt");
//        System.out.println("Simple Path");
//        System.out.printf("toString: %s%n%n", p1);
//
//        Path p2 = p1.toAbsolutePath();
//        System.out.println("Absolute Path");
//        System.out.printf("toString: %s%n", p2);
//        System.out.printf("getFileName: %s%n", p2.getFileName());
//        System.out.printf("getName(0): %s%n", p2.getName(0));
//        System.out.printf("getNameCount: %d%n", p2.getNameCount());
//        System.out.printf("subpath(0,1): %s%n", p2.subpath(0, 1));
//        System.out.printf("getParent: %s%n", p2.getParent());
//        System.out.printf("getRoot: %s%n", p2.getRoot());
//
//        try (Stream<String> streamOfString = Files.lines(p1)) {
//            System.out.println(p1.getFileName());
//            List<String> content = streamOfString
//                    .map(s -> s.toUpperCase())
//                    .collect(Collectors.toList());
//            Files.write(Paths.get("D:\\TT.txt"), content, Charset.defaultCharset(), StandardOpenOption.APPEND);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }

        Path p3 = Paths.get("D:\\Polindromisme.txt");
        try (Stream<String> polindromeText = Files.lines(p3)) {
//            polindromeText.forEach(System.out::println);
            polindromeText.filter(ReadFile.isPalindrome()).forEach(System.out::println);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

    }
}
