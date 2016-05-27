package com.atm;

import java.io.Serializable;
import java.util.*;

public class ATM implements IATM, Serializable {

    private Map<Nominal, Integer> money;
    private int totalAmount;

    public ATM() {
        money = new HashMap<>(Nominal.values().length);
        Arrays.stream(Nominal.values()).forEach(n -> money.put(n, 0));
        totalAmount = 0;
    }

    @Override
    public int put(Nominal n, int count) throws IllegalArgumentException {
        if (count < 0)
            throw new IllegalArgumentException("Count must be greater than 0");

        totalAmount += nominalToInt(n) * count;

        money.put(n, money.get(n) + count);

        return totalAmount;
    }

    @Override
    public Map<Nominal, Integer> get(int amount) {
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

    @Override
    public int quit() {
        System.out.println("Bye!");
        return 0;
    }

    private int nominalToInt(Nominal n) {
        switch (n) {
            case ONE:
                return 1;
            case FIVE:
                return 5;
            case TEN:
                return 10;
            case FIFTY:
                return 50;
            case HUNDRED:
                return 100;
            case FIVE_HUNDRED:
                return 500;
            case THOUSAND:
                return 1000;
            default:
                return 0;
        }
    }
}
