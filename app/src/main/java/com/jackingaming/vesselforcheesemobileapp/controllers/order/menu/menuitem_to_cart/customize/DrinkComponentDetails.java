package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.customize;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;

import java.util.List;

public class DrinkComponentDetails {
    private String keyGroup;
    private List<DrinkComponentWithDefaultAsString> drinkComponents;

    public DrinkComponentDetails(String keyGroup, List<DrinkComponentWithDefaultAsString> drinkComponents) {
        this.keyGroup = keyGroup;
        this.drinkComponents = drinkComponents;
    }

    public String getKeyGroup() {
        return keyGroup;
    }

    public void setKeyGroup(String keyGroup) {
        this.keyGroup = keyGroup;
    }

    public List<DrinkComponentWithDefaultAsString> getDrinkComponents() {
        return drinkComponents;
    }

    public void setDrinkComponents(List<DrinkComponentWithDefaultAsString> drinkComponents) {
        this.drinkComponents = drinkComponents;
    }
}
