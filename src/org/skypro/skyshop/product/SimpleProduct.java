package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double productPrice;

    public SimpleProduct(String productName, double productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }
}
