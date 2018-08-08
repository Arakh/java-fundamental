package com.mitrais.bootcamp.parallel.java8;

import java.util.stream.*;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/** Version of the first array-sum example, but using
 *  Java 8 streams instead of explicit fork/join.
 */

public class MathUtils {
  public static double arraySum(double[] nums) {
    return(DoubleStream.of(nums).sum());
  }
  
  public static double arraySumParallel(double[] nums) {
    return(DoubleStream.of(nums).parallel().sum());
  }
  
  public static double[] randomNums(int length) {
    double[] nums = new double[length];
    for(int i=0; i<length; i++) {
      nums[i] = Math.random();
    }
    return(nums);
  }
  
  @Test
  public void testSum() {
    double[] nums = { 1.1, 2.2, 3.3 };
    double sum = arraySum(nums);
    assertThat(sum, is(6.6));
  }
}
