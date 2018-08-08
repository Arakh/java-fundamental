package com.mitrais.bootcamp.parallel;

public interface Funct<T,R> {
  R computeValue(T input);
}