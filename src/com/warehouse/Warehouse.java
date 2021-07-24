package com.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse implements IWarehouse{
    private int materials_count = 0;
    private int square;
    private int free_square;
    private float full_cost = 0;
    private Map<Integer, Warehouse_record> repo;

    Warehouse(int square)
    {
        this.square = square;
        this.free_square = square;
        this.repo = new HashMap<>();
    }

    @Override
    public String toString() {

        return String.format("Площадь: %d кв. м. Свободная площадь: %d Наименований: %d Единиц на складе: %d Общая стоимость: %15.2f руб.",
                            square, free_square, repo.size(), materials_count, full_cost);
    }

    @Override
    public void add(Warehouse_record record) {
        repo.put(record.getId(), record);
        materials_count += record.getCount();
        full_cost += record.getCost();
        free_square = free_square - record.getSquare();
    }

    @Override
    public void delete(Warehouse_record record) {
        repo.remove(record.getId());
        materials_count -= record.getCount();
        full_cost -= record.getCost();
        free_square += record.getSquare();
    }

    @Override
    public void update(Warehouse_record record) {
        Warehouse_record update_record = repo.get(record.getId());
        materials_count = materials_count - update_record.getCount() + record.getCount();
        full_cost = full_cost - update_record.getCost() + record.getCost();
        free_square = free_square - update_record.getSquare() + record.getSquare();
        update_record.setCount(record.getCount());
        update_record.setSquare(record.getSquare());
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
    public Warehouse_record_info getRecord(Integer Id) {
        return new Warehouse_record_info(repo.get(Id));
    }

    @Override
    public int getFree_square() {
        return free_square;
    }

    @Override
    public boolean containsRecord(Warehouse_record record) {
        return repo.containsValue(record);
    }

    @Override
    public boolean containsId(Integer Id) {
        return repo.containsKey(Id);
    }

    @Override
    public void clear() {
        repo = new HashMap<>();
        materials_count = 0;
        free_square = square;
        full_cost = 0;
    }
}
