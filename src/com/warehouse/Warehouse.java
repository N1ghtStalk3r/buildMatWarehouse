package com.warehouse;

import java.util.Map;

public class Warehouse implements IWarehouse{
    private int materials_count = 0;
    private int square;
    private int free_square;
    private float full_cost;
    private int last_Id = 0;
    private Map<Integer, Material> repo;

    Warehouse(Map<Integer, Material> repo, int square)
    {
        this.square = square;
        this.free_square = square;
        this.repo = repo;
        this.full_cost = 0;
    }

    @Override
    public String toString() {

        return String.format("Площадь: %d кв. м. Свободная площадь: %d Наименований: %d ед.: %d Общая стоимость: %15.2f руб.",
                            square, free_square, repo.size(), materials_count, full_cost);
    }

    @Override
    public String getReport(String check_name) {
        int sum_square = 0;
        int sum_count = 0;
        float sum_cost = 0;
        Integer current_count = 0;
        StringBuilder report = new StringBuilder();
        report.append(String.format("|%-10s||%-50s||%10s||%5s||%15s||%20s||%15s|%s",
                "Код", "Наименование", "Кол-во", "ед.", "Цена руб.", "Стоимость руб.", "Площадь кв. м.", System.lineSeparator()));
        for (Map.Entry<Integer, Material> item: repo.entrySet()
        ) {
            if (item.getValue().getName().toLowerCase().contains(check_name)) {
                sum_cost += item.getValue().getCost();
                sum_count += item.getValue().getCount();
                sum_square += item.getValue().getSquare();
                current_count++;
                report.append(String.format("|%-10d|%s%s",item.getKey(), item.getValue().toString(), System.lineSeparator()));
            }
        }
        report.append(System.lineSeparator());
        report.append(String.format("|%-10s|","Итого"));
        report.append(String.format(Material.format_string, current_count, sum_count,"", 0f, sum_cost, sum_square));
        return report.toString();
    }

    @Override
    public int Add(Material material) {
        last_Id++;
        repo.put(last_Id, material);
        free_square -= material.getSquare();
        materials_count += material.getCount();
        full_cost += material.getCost();
        return last_Id;
    }

    @Override
    public void Delete(int Id) {
        repo.remove(Id);
    }

    @Override
    public int getMaterialsCount() {
        return materials_count;
    }

    @Override
    public boolean Contains(Material material) {

        for (Map.Entry<Integer, Material> item: repo.entrySet()
             ) {
            if (item.getValue().equals(material)) return true;
        }
        return false;
    }

}
