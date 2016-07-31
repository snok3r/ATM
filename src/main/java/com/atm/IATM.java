package com.atm;

import java.util.Map;

public interface IATM {
    int put(Nominal n, int count) throws IllegalArgumentException;

    Map<Nominal, Integer> get(int amount);

    Map<Nominal, Integer> dump();

    int state();

    int quit();
}
