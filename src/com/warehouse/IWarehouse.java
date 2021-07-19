package com.warehouse;

import java.util.Set;

public interface IWarehouse {

    int Add(Warehouse_record record) throws Exception;
    void Delete(int Id);
    int getMaterialsCount();
    boolean Contains(Material material);
    Set<Integer> getId_list();
    Warehouse_record getRecord(Integer Id);
    int getFree_square();
    String getFormat_string();
}
