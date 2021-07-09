package com.warehouse;

import java.util.Objects;

public class Material {
    private String name;
    private int count;
    private String unit;
    private int square;

    Material(String name, int count, int square, String unit) {
        this.name = name;
        this.count = count;
        this.unit = unit;
        this.square = square;
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

    @Override
    public String toString() {
        return String.format("%s - количество %d %s площадь на складе %d" , name, count, unit, square);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return this.name.equalsIgnoreCase(material.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }
}