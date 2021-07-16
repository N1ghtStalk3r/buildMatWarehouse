package com.warehouse;

import java.util.HashMap;

public class Main {
    private static HashMap<Integer, Material> repo;

    public static void main(String[] args) {

        repo = new HashMap<>();
        Material m1 = new Material(1, "M1", 5, 12, "кг.", 20);
        Material m2 = new Material(2, "M1112", 15, 5, "шт.", 10);
        Material m3 = new Material(3, "M2211", 25, 166, "т.", 30);

        Warehouse wh = new Warehouse(repo, 100);
//        wh.Add(m1);
//        wh.Add(m2);
//        wh.Add(m3);
        Manager manager = new Manager(wh);
        manager.Add(m1);
        manager.Add(m2);
        manager.Add(m3);
        manager.getReport("");
    }
}