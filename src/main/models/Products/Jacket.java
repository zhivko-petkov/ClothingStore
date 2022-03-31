package main.models.Products;

import main.common.ExceptionMessages;

import java.math.BigDecimal;

public class Jacket extends Product {
    private int size;

    public Jacket(String name, String brand, double price, String color, int size) {
        super(name, brand, price, color);
        setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if((size >= 42 && size <= 66) && (size % 2 == 0)){
            this.size = size;
        } else {
            throw new IllegalArgumentException(ExceptionMessages.CLOTH_SIZE);
        }
    }
}
