package com.mitrais.bootcamp.parallel;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Tester3 {
  public static void main(String[] args) {
    String message1 = "Sequential min of %,d numbers is %,.4f.";
    String message2 = "Parallel min of   %,d numbers is %,.4f.";
    for (int i=3; i<8; i++) {
      int arraySize = (int)Math.pow(10, i)/2;
      Double[] nums = MathUtils.randomNums2(arraySize);
      TimingUtils.timeOp(new Op() {
        @Override
        public String runOp() {
          double min = MathUtils.smallestFancyValue(nums);
          return(String.format(message1, arraySize, min));
        }
      });
      TimingUtils.timeOp(new Op() {
        @Override
        public String runOp() {
          double min = MathUtils.smallestFancyValueParallel(nums);
          return(String.format(message2, arraySize, min));
        }
      });
    }
  }
  
  /** JUnit test routine. The sequential and parallel versions
   *  should yield the exact same number (since there is no addition),
   *  so no roundoff error is involved and the simpler equalTo
   *  matcher method is used.
   */
  @Test
  public void testSmallest() {
    for (int i=1; i<5; i++) {
      int arraySize = (int)Math.pow(10, i);
      Double[] nums = MathUtils.randomNums2(arraySize);
      Double min1 = MathUtils.smallestFancyValue(nums);
      Double min2 = MathUtils.smallestFancyValueParallel(nums);
      assertThat(min1, is(equalTo(min2)));
    }
  }
}

