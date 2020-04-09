package com.devcolibri.logic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest {

    private Calc calc = new Calc();

    @Test
    public void testSum() throws Exception {
        Assert.assertEquals(5, calc.sum(2,3));
    }
}
