package com.atm;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ATMTest {
    private IATM atm;
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-test.xml");

    @Before
    public void setUp() throws Exception {

        atm = context.getBean("testATM", IATM.class);
        assertEquals(atm.state(), 1666);
    }

    @Test(expected = IllegalArgumentException.class)
    public void put_negative_amount() throws Exception {
        int stateBefore = atm.state();

        try {
            atm.put(Nominal.FIFTY, -1);
        } catch (IllegalArgumentException e) {
            throw e;
        } finally {
            assertEquals(stateBefore, atm.state());
        }
    }

    @Test
    public void put_1000_by_500() throws Exception {
        int stateBefore = atm.state();

        atm.put(Nominal.FIVE_HUNDRED, 2);

        assertEquals(atm.state(), stateBefore += 1000);
    }
}