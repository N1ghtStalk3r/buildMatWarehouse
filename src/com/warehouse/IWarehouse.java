package com.warehouse;

import java.util.Set;

public interface IWarehouse {

    void add(Warehouse_record record);
    void delete(Warehouse_record record);
    void update(Warehouse_record record);
    void clear();
    boolean containsRecord(Warehouse_record record);
    boolean containsId(Integer Id);
    int count();
    int materialsCount();
    Set<Integer> getId_list();
    Warehouse_record_info getRecord(Integer Id);
    int getFree_square();
}
