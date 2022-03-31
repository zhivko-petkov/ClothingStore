package main.models.Products;

import main.common.ExceptionMessages;

import java.math.BigDecimal;

public class Shoe extends Product {
    private int size;

    public Shoe(String name, String brand, double price, String color, int size) {
        super(name, brand, price, color);
        setSize(size);
    }

    public void setSize(int size) {
        if(size >= 39 && size <= 46){
            this.size = size;
        } else {
            throw new IllegalArgumentException(ExceptionMessages.CLOTH_SIZE);
        }

    }

    public int getSize() {
        return size;
    }
}
