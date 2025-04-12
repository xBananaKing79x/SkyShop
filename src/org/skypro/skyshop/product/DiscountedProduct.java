package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private double basePrice;//Базовая цена товара
    private int discountedProcentage;//Величина скидки

    public DiscountedProduct(String productName, double basePrice, int discountedProcentage) {
        super(productName);
        this.discountedProcentage = discountedProcentage;
    }

    @Override
    public double getProductPrice() {
        return basePrice * (1-discountedProcentage/100.0);//Учет скидки
    }
}
