package com.warehouse;

import java.util.Objects;

public class Material {
    private String name;
    private String unit;
    private float price;

    Material(String name, String unit, float price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    String getName() {
        return name;
    }

    void setName(String new_name) {
          name = new_name;
    }

    String getUnit() {
        return unit;
    }

    void setUnit(String new_unit) {
          unit = new_unit;
    }

    float getPrice(){ return price; }

    void setPrice(float new_price) {
        this.price = new_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return (this.name.equalsIgnoreCase(material.getName()) && (this.price == material.getPrice()) && (this.unit.equalsIgnoreCase(material.getUnit())));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), price, unit);
    }
}