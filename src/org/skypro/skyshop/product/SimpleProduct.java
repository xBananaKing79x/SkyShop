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

    //Переопределяем метод
    @Override
    public boolean isSpecial() {
        return false;//Обычный продукт не является специальным
    }

}
