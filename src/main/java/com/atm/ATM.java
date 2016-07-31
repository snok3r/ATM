package com.atm;

import java.util.*;

public class ATM implements IATM {

    private final Map<Nominal, Integer> money;
    private int totalAmount;

    public ATM(Map<Nominal, Integer> money) {
        this.money = money;

        this.totalAmount = recountMoney();
    }

    @Override
    public int put(Nominal n, int count) throws IllegalArgumentException {
        if (count <= 0)
            throw new IllegalArgumentException("Count must be greater than 0");

        money.put(n, money.get(n) + count);

        return totalAmount = recountMoney();
    }

    @Override
    public Map<Nominal, Integer> get(int amount) {

        totalAmount = recountMoney();
        return null;
    }

    @Override
    public Map<Nominal, Integer> dump() {
        return Collections.unmodifiableMap(money);
    }

    @Override
    public int state() {
        return totalAmount;
    }

    private int recountMoney() {
        int totalAmount = 0;

        for (Map.Entry e : money.entrySet()) {
            int amount = ((Nominal) e.getKey()).getValue();
            int count = (int) e.getValue();

            totalAmount += amount * count;
        }

        return totalAmount;
    }

    @Override
    public int quit() {
        money.clear();
        System.out.println("Bye!");
        return 0;
    }
}
