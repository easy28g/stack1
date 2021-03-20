package com.company.models;

import com.company.enums.Unit;

import java.util.Objects;

public class Product {

    private int id;
    private String name;
    private String kindName;
    private double amount;
    private Unit unit;

    public Product(int id, String name, String kindName, double amount, Unit unit) {
        this.id = id;
        this.name = name;
        this.kindName = kindName;
        this.amount = amount;
        this.unit = unit;
    }

    public Product(String name, String kindName, double amount, Unit unit) {
        this.name = name;
        this.kindName = kindName;
        this.amount = amount;
        this.unit = unit;
    }


    public Product(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", kindName='" + kindName + '\'' +
                ", amount=" + amount +
                ", unit=" + unit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) &&
                kindName.equals(product.kindName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kindName);
    }
}
