package com.mitrais.bootcamp.parallel;

public class ArrayAdder 
       implements SequentialArrayProcessor<Double,Double> {
  @Override
  public Double computeValue(Double[] values, 
                             int lowIndex, int highIndex) {
    return(MathUtils.arraySum(values, lowIndex, highIndex));
  }
}
