package com.warehouse;

import java.util.Map;

public class Warehouse implements IWarehouse{
    private int materials_count = 0;
    private int square;
    private int free_square;
    private int last_Id = 0;
    private Map<Integer, Material> repo;

    Warehouse(Map<Integer, Material> repo, int square)
    {
        this.square = square;
        this.free_square = square;
        this.repo = repo;
    }

    @Override
    public String toString() {

        return String.format("Склад: Площадь - %d кв. м. Свободная площадь - %d Наименований: %d ед.: %d",
                            square, free_square, repo.size(), materials_count);
    }

    @Override
    public String fullReport() {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<Integer, Material> item: repo.entrySet()
        ) {
            report.append(String.format("%s %s",item.toString(), System.lineSeparator()));
        }
        report.append(this);
        return report.toString();
    }

    @Override
    public int Add(Material material) {
        last_Id++;
        repo.put(last_Id, material);
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
}
