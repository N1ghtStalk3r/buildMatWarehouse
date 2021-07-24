package com.warehouse;

public class Warehouse_record_info {
    private String Name;
    private String Unit;
    private float Price;
    private float Cost;
    private int Count;
    private int Square;

    public Warehouse_record_info(Warehouse_record record) {
        Name = record.getMaterial().getName();
        Unit = record.getMaterial().getUnit();
        Price = record.getMaterial().getPrice();
        Cost = record.getCost();
        Count = record.getCount();
        Square = record.getSquare();
    }

    public String getName() {
        return Name;
    }

    public String getUnit() {
        return Unit;
    }

    public float getPrice() {
        return Price;
    }

    public float getCost() {
        return Cost;
    }

    public int getCount() {
        return Count;
    }

    public int getSquare() {
        return Square;
    }
}
