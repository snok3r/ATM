package com.atm;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ATMTest {

    private IATM atm;

    @Before
    public void setUp() throws Exception {

        Map<Nominal, Integer> money = new HashMap<>();
        for (Nominal n : Nominal.values())
            money.put(n, 1);

        atm = new ATM(money);

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