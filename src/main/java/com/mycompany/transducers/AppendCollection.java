/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.transducers;

import java.util.Collection;

/**
 *
 * @author Joe
 * @param <R>
 */
public class AppendCollection<R> implements Reducer<R,Collection<R>>{
    

    @Override
    public Collection<R> apply(R t, Collection<R> u) {
        u.add(t);
        return u;
    }
    
}
