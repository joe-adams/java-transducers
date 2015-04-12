/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.transducers;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 * @author Joe
 * @param <R>
 */
public interface Reducer<V,R> extends BiFunction<V,R,R> {

}
