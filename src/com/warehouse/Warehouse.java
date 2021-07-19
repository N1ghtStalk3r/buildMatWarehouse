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

        return String.format("Площадь: %d кв. м. Свободная площадь: %d Наименований: %d ед.: %d Общая стоимость: %15.2f руб.",
                            square, free_square, repo.size(), materials_count, full_cost);
    }

    @Override
    public int Add(Warehouse_record record) throws Exception {
        String testRecord_string = testRecord(record);
        if (!testRecord_string.isEmpty()) {
            new Exception(testRecord_string);
        }
        record.setId(++last_Id);
        repo.put(last_Id, record);
        materials_count += record.getCount();
        full_cost += record.getCost();
        free_square -= record.getSquare();
        return last_Id;
    }

    @Override
    public void Delete(int Id) {
        Warehouse_record record = getRecord(Id);
        materials_count -= record.getCount();
        full_cost -= record.getCost();
        free_square += record.getSquare();
        repo.remove(Id);
    }

    @Override
    public int getMaterialsCount() {
        return materials_count;
    }

    @Override
    public boolean Contains(Material material) {

        for (Map.Entry<Integer, Warehouse_record> item: repo.entrySet()
             ) {
            if (item.getValue().checkMaterial(material)) return true;
        }
        return false;
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

    @Override
    public String getFormat_string() {
        return format_string;
    }

    String testRecord(Warehouse_record record)
    {
        if (record == null) {
            return "Не задана складская запись ";
        }
        if (record.getCount() < 1) {
            return "Количество товара меньше 1";
        }
        if (record.getSquare() < 1) {
            return "Площадь меньше 1";
        };
        return "";
    }
}
