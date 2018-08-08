/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.generic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aditia_RS458
 */
public class FilterList<E> {
    
    public <T> List filterList(List<T> originalList, Filter filter, E text){
        List<T> filterList = new ArrayList<T>();
        for(T object : originalList){
            if(filter.isMatched(object, text)){
                filterList.add(object);
            }
        }
        
        return filterList;
    }
    
}
