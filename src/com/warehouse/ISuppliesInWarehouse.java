package com.warehouse;

public interface ISuppliesInWarehouse {
    int AddEntry(SuppliesInWarehouse inEntryWarehouse);

    void Delete(int Id);

    String fullReport();

    int getMaterialsCount();

    boolean Contains(Material material);
}
