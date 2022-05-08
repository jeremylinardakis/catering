package com.techelevator.Fooditems;

import java.math.BigDecimal;

public class Food {
    private String type;
    private String name;
    private BigDecimal price;
    private String slotLocation;
    private int quantity = 7;

    public Food(String slotLocation, String name, String type, BigDecimal price, int quantity){
        this.type = type;
        this.name = name;
        this.price = price;
        this.slotLocation = slotLocation;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public int getQuantity() {
        return quantity;
    }
}
