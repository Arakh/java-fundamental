package com.mitrais.bootcamp.parallel;

public class FancyArrayMinimizer 
       implements SequentialArrayProcessor<Double,Double> {
  @Override
  public Double computeValue(Double[] values, 
                             int lowIndex, 
                             int highIndex) {
    return(MathUtils.smallestFancyValue(values, 
                                        lowIndex, 
                                        highIndex));
  }
}
