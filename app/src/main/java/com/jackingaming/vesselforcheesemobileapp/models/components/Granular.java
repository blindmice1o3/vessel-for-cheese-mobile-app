package com.jackingaming.vesselforcheesemobileapp.models.components;

public interface Granular {
    enum Amount { NO, LIGHT, MEDIUM, EXTRA; }

    Amount getAmount();

    void setAmount(Amount amount);
}
