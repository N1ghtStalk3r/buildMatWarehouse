package com.warehouse;

import java.util.Set;

public interface IWarehouse {

    int add(Warehouse_record record);
    void delete(Warehouse_record record);
    int count();
    int materialsCount();
    Set<Integer> getId_list();
    Warehouse_record getRecord(Integer Id);
    int getFree_square();
}
