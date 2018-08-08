package com.mitrais.bootcamp.parallel;

public class Minimizer implements Combiner<Double> {
  @Override
  public Double combine(Double d1, Double d2) {
    return(Math.min(d1, d2));
  }
}
