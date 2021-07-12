package com.warehouse;

import java.util.HashMap;

public class Main {
    private static HashMap<Integer, Material> repo;

    public static void main(String[] args) {

        repo = new HashMap<>();
        Material m1 = new Material("M1", 5, 12, "кг.", 20);
        Material m2 = new Material("M1112", 15, 5, "шт.", 10);
        Material m3 = new Material("M2211", 25, 6, "т.", 30);

        Warehouse wh = new Warehouse(repo, 100);
        wh.Add(m1);
        wh.Add(m2);
        wh.Add(m3);
        System.out.println(wh.getReport("m1"));
    }
}