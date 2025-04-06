package org.skypro.skyshop.product;

public class Product {
    private String productName;
    private int productPrice;

    public Product(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public String getProductName () {
        return productName;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public String toString() {
        return productName + ": " + productPrice;
    }
}
