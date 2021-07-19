package com.warehouse;

import java.util.Objects;

class Warehouse_record{

    private Material material;
    private int square;
    private int count;
    private int Id;

    Warehouse_record(Material material, int Id, int square, int count) {
        this.material = material;
        this.square = square;
        this.count = count;
        this.Id = Id;
    }

    int getSquare(){
        return square;
    }

    void setSquare(int new_square){
        square = new_square;
    }

    void setId(Integer new_Id){
        Id = new_Id;
    }

    int getId() { return Id; }

    float getCost(){
        return material.getPrice() * count;
    }

    int getCount(){
        return count;
    }

    void setCount(int new_count){
        count = new_count;
    }

    String getName() {
        return material.getName();
    }

    void setName(String new_name) {
        material.setName(new_name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse_record that = (Warehouse_record) o;
        return Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material);
    }
}
