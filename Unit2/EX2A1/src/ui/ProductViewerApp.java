package ui;

import Buisness.Product;
import Data.ProductDB;

public class ProductViewerApp {

    public static void main(String[] args) {
        System.out.println("Welcome To The Buisness.Product Viewer App! \n");

        Product product1 = new Product();
        System.out.println(product1);

        Product product2 = new Product("net","Programming with C#",55.80);
        System.out.println(product2);

        Product product3 = ProductDB.getProduct("php");
        System.out.println(product3);

        Product product4 = ProductDB.getProduct("java");
        System.out.println(product4);
    }

}

