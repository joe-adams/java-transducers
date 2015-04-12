/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.transducers;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Joe
 * @param <R>
 */
public class Filter<V,R> implements Reducer<V,R>{
    private final Reducer<V,R> reducer;
    private final Predicate<V> predicate;

    public Filter(Reducer<V,R> reducer, Predicate<V> predicate) {
        this.reducer = reducer;
        this.predicate = predicate;
    }

    @Override
    public R apply(V t, R u) {
        if(predicate.test(t)){
            return reducer.apply(t, u);
        }
        return u;
    }
    
    public static <V,R> Function<Reducer<V,R>,Filter<V,R>> curryPredicate(Predicate<V> predicate){
        return (Reducer<V,R> reducer) -> new Filter<>(reducer, predicate);
    }
    
    
    
}
