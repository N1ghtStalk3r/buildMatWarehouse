package com.warehouse;

public interface IWarehouse {

    int Add(Material material);
    void Delete(int Id);
    String fullReport();
    int getMaterialsCount();
    boolean Contains(Material material);
}
