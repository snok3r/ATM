package com.atm;

import static org.junit.Assert.*;

public class ATMTest {
    private ATM atm;

    @org.junit.Before
    public void setUp() throws Exception {
        atm = new ATM();

        atm.put(Nominal.ONE, 1);
        atm.put(Nominal.FIVE, 1);
        atm.put(Nominal.TEN, 1);
        atm.put(Nominal.FIFTY, 1);
        atm.put(Nominal.HUNDRED, 1);
        atm.put(Nominal.FIVE_HUNDRED, 1);
        atm.put(Nominal.FIVE_HUNDRED, 1);
        atm.put(Nominal.THOUSAND, 1);
        atm.put(Nominal.THOUSAND, 1);

        assertEquals(atm.state(), 3166);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void putNegative() throws Exception {
        atm.put(Nominal.FIFTY, -1);
    }
}