package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.customize;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

import java.util.List;

public class DrinkComponentDetails {
    private String keyGroup;
    private List<String> drinkComponentsDefault;
    private List<DrinkComponent> drinkComponents;

    public DrinkComponentDetails(String keyGroup, List<String> drinkComponentsDefault, List<DrinkComponent> drinkComponents) {
        this.keyGroup = keyGroup;
        this.drinkComponentsDefault = drinkComponentsDefault;
        this.drinkComponents = drinkComponents;
    }

    public String getKeyGroup() {
        return keyGroup;
    }

    public void setKeyGroup(String keyGroup) {
        this.keyGroup = keyGroup;
    }

    public List<String> getDrinkComponentsDefault() {
        return drinkComponentsDefault;
    }

    public void setDrinkComponentsDefault(List<String> drinkComponentsDefault) {
        this.drinkComponentsDefault = drinkComponentsDefault;
    }

    public List<DrinkComponent> getDrinkComponents() {
        return drinkComponents;
    }

    public void setDrinkComponents(List<DrinkComponent> drinkComponents) {
        this.drinkComponents = drinkComponents;
    }
}
