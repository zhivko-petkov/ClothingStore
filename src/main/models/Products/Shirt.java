package main.models.Products;

import main.common.ExceptionMessages;

import java.math.BigDecimal;
import java.util.List;

public class Shirt extends Product {

    private String size;

    public Shirt(String name, String brand, double price, String size, String color) {
        super(name, brand, price, color);
        setSize(size);
    }


    public void setSize(String size) {
        if(List.of("XS", "S", "M", "L", "XL", "2XL").contains(size)){
            this.size = size;
        } else {
            throw new IllegalArgumentException(ExceptionMessages.CLOTH_SIZE);
        }

    }

    public String getSize() {
        return size;
    }
}
