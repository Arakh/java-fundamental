package com.mitrais.bootcamp.parallel;

import java.math.*;

public class PrimeStorer 
       implements SequentialArrayProcessor<BigInteger,Void> {
  @Override
  public Void computeValue(BigInteger[] primes, 
                           int lowerIndex, int upperIndex) {
    MathUtils.findPrimes(primes, lowerIndex, upperIndex);
    return(null);
  }
}
