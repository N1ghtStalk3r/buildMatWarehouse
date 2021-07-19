package com.warehouse;

class Warehouse_record{

    private Material material;
    private int square;

    Warehouse_record(Material material, int square) {
        this.material = material;
        this.square = square;
    }

    int getSquare(){
        return square;
    }

    void setSquare(int new_square){
        square = new_square;
    }

    void setId(Integer Id){
        material.setId(Id);
    }

    float getCost(){
        return material.getCost();
    }

    int getCount(){
        return material.getCount();
    }

    boolean checkMaterial(Material material) {
        return this.material.equals(material);
    }

    String getName() {
        return material.getName();
    }

    void setName(String new_name) {
        material.setName(new_name);
    }
}
