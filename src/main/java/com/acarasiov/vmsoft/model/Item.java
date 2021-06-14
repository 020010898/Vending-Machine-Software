package com.acarasiov.vmsoft.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@JsonAutoDetect
public class Item {

    public Configuration config;
    private int itemId;
    private String name;
    private BigDecimal itemPrice;
    private String price;
    private int amount;
    private List<Item> items;

    public Item(int itemId, String name, BigDecimal price, int amount) {
        this.itemId = itemId;
        this.name = name;
        this.itemPrice = price;
        this.amount = amount;
    }

    public Item() {
    }


    @JsonIgnore
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getItemPrice() {
        return new BigDecimal(getPrice());
    }

    public void setItemPrice(BigDecimal price) {
        setPrice(price.toString());
        this.itemPrice = new BigDecimal(this.price);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price.substring(1);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.itemId;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.price);
        hash = 53 * hash + this.amount;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.itemId != other.itemId) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
