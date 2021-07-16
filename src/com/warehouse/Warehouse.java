package com.warehouse;

import java.util.Map;
import java.util.Set;

public class Warehouse implements IWarehouse{
    private int materials_count = 0;
    private int square;
    private int free_square;
    private float full_cost;
    private int last_Id = 0;
    static String format_string = "|%-10s||%-50s||%10s||%5s||%15s||%20s||%15s|";
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
    public int Add(Material material) {
        if (material != null) {
            material.setId(++last_Id);
            repo.put(last_Id, material);
            free_square -= material.getSquare();
            materials_count += material.getCount();
            full_cost += material.getCost();
            return last_Id;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public void Delete(int Id) {
        Material material = getMaterial(Id);
        materials_count -= material.getCount();
        free_square += material.getSquare();
        full_cost -= material.getCost();
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

    @Override
    public Set<Integer> getId_list() {
        return repo.keySet();
    }

    @Override
    public Material getMaterial(Integer Id) {
        return repo.get(Id);
    }

    @Override
    public int getFree_square() {
        return free_square;
    }

    @Override
    public String getFormat_string() {
        return format_string;
    }
}
