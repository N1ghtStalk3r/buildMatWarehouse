package com.warehouse;

import java.util.Set;

public interface IWarehouse {

    int Add(Material material);
    void Delete(int Id);
    int getMaterialsCount();
    boolean Contains(Material material);
    Set<Integer> getId_list();
    Material getMaterial(Integer Id);
    int getFree_square();
    String getFormat_string();
}
