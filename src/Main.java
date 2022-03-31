import main.models.Cart;
import main.models.Cashier;
import main.models.Products.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //Example #1
        //Products In CartA
        Product productA = new Shirt("Blue Cotton Shirt", "BrandS", 14.99, "M", "blue");
        Product productB = new Shirt("White Cotton Shirt", "BrandS", 15.99, "M", "white");
        Product productC = new Trouser("Black Cotton Trousers", "BrandT", 29.99, "black", 50);
        Product productD = new Shoe("Black Leather Shoes", "BrandS", 59.99, "black", 43);
        Product productE = new Jacket("Black Cotton Suit Jacket", "BrandJ", 99.99, "black", 50);

        //Add products in cart
        Cart cartA = new Cart();
        cartA.addProduct(productA);
        cartA.addProduct(productB);
        cartA.addProduct(productC);
        cartA.addProduct(productD);
        cartA.addProduct(productE);

        //Billing products
        Cashier cashierA = new Cashier(cartA, LocalDateTime.parse("2022-02-02 12:34:56", formatter));
        System.out.println(cashierA.printInvoice());




        //Example #2
        Product productQ = new Shirt("Black Silk Shirt", "BrandS", 29.99, "L", "black");
        Product productW = new Shirt("White Silk Shirt", "BrandS", 29.99, "L", "white");

        //Add products in cart
        Cart cartB = new Cart();
        cartB.addProduct(productQ);
        cartB.addProduct(productW);

        //Billing products
        Cashier cashierB = new Cashier(cartB, LocalDateTime.parse("2022-02-01 12:34:56", formatter));
        //System.out.println(cashierB.printInvoice());




        //Example #3
        Product productR = new Trouser("Red Linen Trousers", "BrandT", 49.99, "red", 56);
        Product productT = new Shoe("Red Suede Shoes", "BrandS", 59.99, "red", 44);
        Product productY = new Shoe("Black Suede Shoes", "BrandS", 59.99, "black", 44);
        Product productU = new Jacket("Red Linen Suit Jacket", "BrandJ", 99.99, "red", 56);
        Product productI = new Shirt("White Linen Shirt", "BrandS", 29.99, "L", "white");

        //Add products in cart
        Cart cartC = new Cart();
        cartC.addProduct(productR);
        cartC.addProduct(productT);
        cartC.addProduct(productY);
        cartC.addProduct(productU);
        cartC.addProduct(productI);

        //Billing products
        Cashier cashierC = new Cashier(cartC, LocalDateTime.parse("2022-02-01 12:34:56", formatter));
        //System.out.println(cashierC.printInvoice());


    }


}
