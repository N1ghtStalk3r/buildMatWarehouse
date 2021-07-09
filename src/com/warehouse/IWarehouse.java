package com.warehouse;

public interface IWarehouse {

    int Add(Material material);
    void Delete(int Id);
    String fulReport();
    int getMaterialsCount();
}
