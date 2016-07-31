package com.atm;

public enum Nominal {
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000);

    private final int amount;

    Nominal(int amount) {
        this.amount = amount;
    }

    public int getValue() {
        return amount;
    }
}
