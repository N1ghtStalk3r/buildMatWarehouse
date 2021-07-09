package com.warehouse;

import java.util.Objects;

public class Material {
    private String name;
    private int count;
    private String unit;

    Material(String name, int count, String unit) {
        this.name = name;
        this.count = count;
        this.unit = unit;
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

    @Override
    public String toString() {
        return String.format("%s количество %d %s", name, count, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(name.toLowerCase(), material.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, unit);
    }
}