package com.mitrais.bootcamp.parallel;

public interface SequentialArrayProcessor<T,R> {
  R computeValue(T[] values, 
                 int lowIndex, 
                 int highIndex);
}
