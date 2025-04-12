package org.skypro.skyshop.product;

public abstract class Product {
    String productName;

    public Product(String productName) {
        this.productName = productName;
    }
    public String getProductName () {
        return productName;
    }
    public abstract double getProductPrice();
    public abstract boolean isSpecial();
    public String toString() {
        return productName;
    }
}
