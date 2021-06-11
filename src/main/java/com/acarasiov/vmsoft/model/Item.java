package com.acarasiov.vmsoft.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@JsonAutoDetect
public class Item {

    public Configuration config;
    public String name;
    public int amount;
    public String price;
    public List<Item> items = new ArrayList<Item>();

    public Item() {
    }

    public Item(String name, int amount, String price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public BigDecimal getItemPrice() {
        String itemPrice = price.substring(1);
        return new BigDecimal(itemPrice);
    }

    public void setItemPrice(BigDecimal bigDecimal) {
        setPrice(bigDecimal.toString());
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        if (config != null) {
            return config + "\n" +
                    " items=" + items +
                    '}';
        } else {
            return "Item{\n" +
                    "name='" + name + '\'' +
                    ", amount=" + amount +
                    ", price='" + price + '\'' + "\n" +
                    '}';
        }
    }
}