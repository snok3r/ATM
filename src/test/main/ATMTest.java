package main;

import main.util.Serialize;

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

        //Serialize.serializeUsers("atms.dat", Arrays.asList(atm));
    }

    @org.junit.Test
    public void put() throws Exception {
        try {
            atm.put(Nominal.FIFTY, -1);
            System.out.println("Trying put negative amount of Nominal: FAIL (exception not caught)");
        } catch (IllegalArgumentException e) {
            System.out.println("Trying put negative amount of Nominal: OK (exception caught)");
        }

        assertEquals(atm.state(), 3166);
    }
}