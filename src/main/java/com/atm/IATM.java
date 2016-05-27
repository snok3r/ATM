package com.atm;

import java.util.List;
import java.util.Map;

interface IATM {
    int put(Nominal n, int count) throws IllegalArgumentException;

    Map<Nominal, Integer> get(int amount);

    Map<Nominal, Integer> dump();

    int state();

    int quit();
}
