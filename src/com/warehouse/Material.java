package com.warehouse;

import java.util.Objects;

public class Material {
    private String name;
    private int count;
    private String unit;
    private int square;
    private float price;
    static String format_string = "|%-50s||%10d||%5s||%15.2f||%20.2f||%15d|";

    Material(String name, int count, int square, String unit, float price) {
        this.name = name;
        this.count = count;
        this.unit = unit;
        this.square = square;
        this.price = price;
    }

    String getName() {
        return name;
    }

    void setName(String new_name) {
        if (!new_name.isEmpty()) {
            name = new_name;
        }
    }

    String getUnit() {
        return unit;
    }

    void setUnit(String new_unit) {
        if (!new_unit.isEmpty()) {
            unit = new_unit;
        }
    }

    int getCount() {
        return count;
    }

    void changeCount(int value) {
        count = count + value;
    }

    int getSquare(){
        return square;
    }

    void changeSquare(int value) {
        square = square + value;
    }

    void setSquare(int new_square) {
        this.square = new_square;
    }

    float getPrice(){ return price; }

    void setPrice(float new_price) {
        this.price = new_price;
    }

    float getCost() {return count * price;}

    @Override
    public String toString() {
        return String.format(format_string,
                                name, count, unit, price, price * count, square);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return (this.name.equalsIgnoreCase(material.getName()) & (this.price == material.getPrice()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), price);
    }
}