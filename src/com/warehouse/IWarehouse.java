package com.warehouse;

public interface IWarehouse {

    int Add(Material material);
    void Delete(int Id);
    String getReport(String check_name);
    int getMaterialsCount();
    boolean Contains(Material material);
}
