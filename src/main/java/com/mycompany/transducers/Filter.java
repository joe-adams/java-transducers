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
public class Filter<R> implements BiFunction<R,Collection<R>,Collection<R>>{
    private final Reducer<R> reducer;
    private final Predicate<R> predicate;

    public Filter(Reducer<R> reducer, Predicate<R> predicate) {
        this.reducer = reducer;
        this.predicate = predicate;
    }

    @Override
    public Collection<R> apply(R t, Collection<R> u) {
        if(predicate.test(t)){
            return reducer.apply(t, u);
        }
        return u;
    }
    
    public static <R> Function<Reducer<R>,Filter<R>> curryPredicate(Predicate<R> predicate){
        return (Reducer<R> reducer) ->new Filter<>(reducer,predicate);
    }
    
    
    
}
