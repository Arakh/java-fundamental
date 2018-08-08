package com.mitrais.bootcamp.parallel;

public class SlowFunct implements Funct<Double,Double> {
  @Override
  public Double computeValue(Double input) {
    return(MathUtils.slowFunction(input));
  };
}
