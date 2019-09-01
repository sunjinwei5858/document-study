package com.sunjinwie;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test01(){
        ThreadLocal<String> localName = new ThreadLocal<>();
        localName.set("小明");
        System.out.println(localName.get());


    }
}
