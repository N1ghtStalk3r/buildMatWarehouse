package com.warehouse;

import java.util.HashMap;

public class Main {


    public static void main(String[] args) {

        Warehouse wh = new Warehouse(20);
        Material m1 = new Material("m1", "t", 200);
        Material m2 = new Material("m1", "kg", 200);
        Warehouse_record record1 = new Warehouse_record(m1, 1, 20,20);
        wh.add(record1);
        System.out.println(wh.getRecord(1).getCount());
    }
}