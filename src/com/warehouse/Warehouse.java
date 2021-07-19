package com.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse implements IWarehouse{
    private int materials_count = 0;
    private int square;
    private int free_square;
    private float full_cost;
    private int last_Id = 0;
    private Map<Integer, Warehouse_record> repo;

    Warehouse(Map<Integer, Warehouse_record> repo, int square)
    {
        this.square = square;
        this.free_square = square;
        this.repo = repo;
        this.full_cost = 0;
    }

    @Override
    public String toString() {

        return String.format("Площадь: %d кв. м. Свободная площадь: %d Наименований: %d Единиц на складе: %d Общая стоимость: %15.2f руб.",
                            square, free_square, repo.size(), materials_count, full_cost);
    }

    @Override
    public int add(Warehouse_record record) {
        record.setId(++last_Id);
        repo.put(last_Id, record);
        materials_count += record.getCount();
        full_cost += record.getCost();
        free_square -= record.getSquare();
        return last_Id;
    }

    @Override
    public void delete(Warehouse_record record) {
        materials_count -= record.getCount();
        full_cost -= record.getCost();
        free_square += record.getSquare();
        repo.remove(record.getId());
    }

    @Override
    public int count() {
        return repo.size();
    }

    @Override
    public int materialsCount() {
        return materials_count;
    }

    @Override
    public Set<Integer> getId_list() {
        return repo.keySet();
    }

    @Override
    public Warehouse_record getRecord(Integer Id) {
        return repo.get(Id);
    }

    @Override
    public int getFree_square() {
        return free_square;
    }

}
