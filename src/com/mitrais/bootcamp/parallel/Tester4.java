package com.mitrais.bootcamp.parallel;

import java.math.*;
import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Tester4 {
  public static void main(String[] args) {
    String message1 = "Sequential search for %,d primes.%n" +
                      "First and last are %s and %s.";
    String message2 = "Parallel search for   %,d primes.%n" +
                      "First and last are %s and %s.";
    for (int i=1; i<5; i++) {
      int arraySize = (int)Math.pow(10, i)/2;
      BigInteger[] primes = new BigInteger[arraySize];
      TimingUtils.timeOp(new Op() {
        @Override
        public String runOp() {
          MathUtils.findPrimes(primes);
          return(String.format(message1, arraySize, primes[0], primes[arraySize-1]));
        }
      });
      Arrays.fill(primes, null);
      TimingUtils.timeOp(new Op() {
        @Override
        public String runOp() {
          MathUtils.findPrimesParallel(primes);
          return(String.format(message2, arraySize, primes[0], primes[arraySize-1]));
        }
      });
    }
  }
  
  @Test
  public void testPrimes() {
    for (int i=1; i<4; i++) {
      int arraySize = (int)Math.pow(10, i);
      BigInteger[] nums = new BigInteger[arraySize];
      MathUtils.findPrimes(nums);
      assertThat(Primes.allPrime(nums), is(true));
      Arrays.fill(nums, null);
      MathUtils.findPrimesParallel(nums);
      assertThat(Primes.allPrime(nums), is(true));
    }
  }
}

