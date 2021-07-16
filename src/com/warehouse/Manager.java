package com.warehouse;

import java.util.Map;
import java.util.Set;

public class Manager {
    private IWarehouse wh;

    public Manager(IWarehouse wh) {
        this.wh = wh;
    }

    void getReport(String check_name) {
        Set<Integer> id_list = wh.getId_list();
        int sum_square = 0;
        int sum_count = 0;
        float sum_cost = 0;
        Integer current_count = 0;
        System.out.println(String.format(wh.getFormat_string(),
                "Код", "Наименование", "Кол-во", "ед.", "Цена руб.", "Стоимость руб.", "Площадь кв. м."));
        for (Integer Id: id_list
        ) {
            Material current_material = wh.getMaterial(Id);
            if (current_material.getName().toLowerCase().contains(check_name)) {
                sum_cost += current_material.getCost();
                sum_count += current_material.getCount();
                sum_square += current_material.getSquare();
                current_count++;
                System.out.println(current_material);
            }
        }
        System.out.println(String.format(Material.format_string,"Итого", current_count, sum_count,"", 0f, sum_cost, sum_square));
    }

    void Add(Material material) {
        if (material.getSquare() <= wh.getFree_square()) {
            wh.Add(material);
        }
        else
        {
            System.out.println("Недостаточно свободного места на складе");
        }
    }
}
