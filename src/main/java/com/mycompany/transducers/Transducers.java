/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.transducers;

import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Transducers {
    
    public static <V,R> R reduce(Collection<V> values, Reducer<V,R> reducer, R base) {
        R result=base;
        for(V value:values){
            result=reducer.apply(value, result);
        }
        return result;
    }  
}
