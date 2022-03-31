package main.models;

import main.models.Products.Product;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cashier {
    private Cart cart;
    private LocalDateTime purchaseTime;
    private double discount = 0;
    private double total = 0;

    public Cashier(Cart cart, LocalDateTime purchaseTime) {
        this.cart = cart;
        this.purchaseTime = purchaseTime;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public String printInvoice(){


        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DecimalFormat df = new DecimalFormat("0.00");

        sb.append(String.format("Date: %s%n---Products---%n%n", getPurchaseTime().format(formatter)));

        boolean tuesdayDiscount = getPurchaseTime().getDayOfWeek().equals(DayOfWeek.TUESDAY);
        int countOfProducts = this.cart.getProducts().size();
        double productDiscount = 0;
        for (Product product: this.cart.getProducts()) {
               this.total += product.getPrice();
               int discountInPerc = 0;

               sb.append(String.format("%s %s%n$%.2f%n", product.getName(), product.getBrand(),
                                                                           product.getPrice()));
               String typeOfProduct = product.getClass().getSimpleName();

               boolean iSsetDiscount = false;
               if(tuesdayDiscount) {
                   if (typeOfProduct.equals("Shirt") &&  countOfProducts < 3){
                       productDiscount = product.getPrice() * 0.10;
                       this.discount += round(productDiscount,2);
                       discountInPerc = 10;
                       sb.append(String.format("#discount %d%% -$%.2f%n%n", discountInPerc, productDiscount));
                       iSsetDiscount = true;

                   } else if(typeOfProduct.equals("Shoe")){
                       productDiscount = product.getPrice() * 0.25;
                       discountInPerc = 25;
                       this.discount += round(productDiscount,2);
                       sb.append(String.format("#discount %d%% -$%.2f%n%n", discountInPerc, productDiscount));
                       iSsetDiscount = true;
                   }
               }

               if(countOfProducts >= 3 && (iSsetDiscount == false)){
                   productDiscount = product.getPrice() * 0.2;
                   discountInPerc = 20;
                   this.discount += round(productDiscount,2);
                   sb.append(String.format("#discount %d%% -$%.2f%n%n", discountInPerc, productDiscount));
               }
            }

        sb.append(String.format("---------------------------------" +
                                "------------------------------" +
                                "--------------------%n%n"));
        sb.append(String.format("SUBTOTAL: $%.2f%n", this.total));
        sb.append(String.format("DISCOUNT: -$%.2f%n", this.discount));



        double totalAfterDiscount = this.total - this.discount;

        sb.append(String.format("TOTAL: $%.2f%n", totalAfterDiscount));

        return sb.toString();
        }


        public double getDiscount() {
        return discount;
    }


    }

