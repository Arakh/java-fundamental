package com.mitrais.bootcamp.parallel;

public class Adder implements Combiner<Double> {
  @Override
  public Double combine(Double d1, Double d2) {
    return(d1 + d2);
  }
}
