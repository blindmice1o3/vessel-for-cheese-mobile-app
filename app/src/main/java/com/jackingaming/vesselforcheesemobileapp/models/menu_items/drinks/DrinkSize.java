package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks;

public enum DrinkSize {
    SHORT(8),
    TALL(12),
    GRANDE(16),
    VENTI_HOT(20),
    VENTI_ICED(24),
    TRENTA(30),
    UNIQUE(-1),
    UNDEFINED(-1);

    private final int sizeInFlOz;

    DrinkSize(int sizeInFlOz) {
        this.sizeInFlOz = sizeInFlOz;
    }

    public int getSizeInFlOz() {
        return sizeInFlOz;
    }
}
