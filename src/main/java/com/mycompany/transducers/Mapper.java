/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.transducers;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;



public class Mapper<V,R> implements BiFunction<V,Collection<R>,Collection<R>>  {
    private final Reducer<R> reducer;
    private final Function<V,R> mapping;

    public Mapper(Reducer<R> reducer, Function<V, R> mapping) {
        this.reducer = reducer;
        this.mapping = mapping;
    }

    @Override
    public Collection<R> apply(V t, Collection<R> u) {
        R added=mapping.apply(t);
        Collection<R> result=reducer.apply(added, u);
        return result;
    }
    
    public static <V,R> Function<Reducer<R>,Mapper<V,R>> curryMapping(Function<V,R> mapping){
        return (Reducer<R> reducer) ->new Mapper<>(reducer,mapping);
    }

}
