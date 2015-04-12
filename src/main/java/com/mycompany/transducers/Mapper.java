/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.transducers;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;



public class Mapper<V,I,R> implements Reducer<V,R>  {
    private final Reducer<I,R> reducer;
    private final Function<V,I> mapping;

    public Mapper(Reducer<I,R> reducer, Function<V, I> mapping) {
        this.reducer = reducer;
        this.mapping = mapping;
    }

    @Override
    public R apply(V t, R u) {
        I added=mapping.apply(t);
        R result=reducer.apply(added, u);
        return result;
    }
    
    public static <V,I,R> Function<Reducer<I,R>,Mapper<V,I,R>> curryMapping(Function<V,I> mapping){
        return (Reducer<I,R> reducer) ->new Mapper<V,I,R>(reducer,mapping);
    }

}
