/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.transducers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Joe
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        transducerTest();
    }
    
    public void transducerTest(){
        List<Character> chars=new ArrayList<>();
        chars.add('a');
        chars.add('b');
        chars.add('c');
        chars.add('d');
        chars.add('e');
            
        Reducer reducer=Mapper.curryMapping((Character c)->Character.getNumericValue(c) ).compose(Filter.curryPredicate((Integer i)->i%2==0)).apply(new AppendCollection());
        List<Integer> base=new ArrayList<>();
        
        List<Integer> result=Transducers.reduce(chars, reducer, base);
        
        System.out.println(result);
        
        
    }
}
