package com.warehouse;

import java.util.Map;

public class Warehouse implements IWarehouse{
    private int materials_count = 0;
    private int square = 0;
    private int free_square = 0;
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

        return String.format("Склад: Площадь - %d кв. м. Свободная площадь - %d Наименований: %d Едениц: %d",
                            square, free_square, repo.size(), materials_count);
    }

    @Override
    public String fulReport() {
        StringBuilder report = new StringBuilder();
        report.append(this.toString());
        report.append(System.lineSeparator());

        for (Map.Entry<Integer, Material> item: repo.entrySet()
        ) {
            report.append(String.format("ID %d Наименование %s %s", item.getKey(), item.getValue().getName(), System.lineSeparator()));
        }
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
