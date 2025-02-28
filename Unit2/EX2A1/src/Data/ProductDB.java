package Data;

import Buisness.Product;

public class ProductDB {
    public static Product getProduct (String code) {

        Product product = new Product(code);

        if (code.equalsIgnoreCase("java")) {
            product.setDescription("Murach's Java Programming");
            product.setPrice(57.5);
        }
        else if (code.equalsIgnoreCase("jsp")) {
            product.setDescription("Murach's Java Server Programming");
            product.setPrice(47.4);
        }


        return product;
    }
}
