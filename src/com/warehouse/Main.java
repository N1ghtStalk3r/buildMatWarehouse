package com.warehouse;

import java.util.HashMap;

public class Main {


    public static void main(String[] args) {

        HashMap<Integer, Warehouse_record> repo = new HashMap<>();
        Warehouse wh = new Warehouse(repo, 20);
        Material m1 = new Material("m1", "t", 200);
        wh.add(new Warehouse_record(m1, 1, 20,20));
        System.out.println(wh.count());
        System.out.println(wh.materialsCount());
        System.out.println(wh);
    }
}