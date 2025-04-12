package org.skypro.skyshop.product;

public abstract class Product {
    private String productName;

    public Product(String productName, int productPrice) {
        this.productName = productName;
    }
    public String getProductName () {
        return productName;
    }
    public abstract int getProductPrice();
    public String toString() {
        return productName;
    }
}
