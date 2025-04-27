package org.skypro.skyshop.product;

import org.skypro.skyshop.SearchEngine.Searchable;

public abstract class Product implements Searchable {
    String productName;

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустой строкой или состоять только из пробелов.");
        } else this.productName = productName;
    }
    public String getProductName () {
        return productName;
    }
    public abstract double getProductPrice();
    public abstract boolean isSpecial();
    public String toString() {
        return productName + ": " + getProductPrice();
    }

    //Переопределяем методы интерфейса Searchable
    @Override
    public String getType () {
        return "PRODUCT";
    }
    @Override
    public String getSearchTerm() {
        return productName; //Термин поиска - имя товара
    }
    @Override
    public String getSearchableName() {
        return productName;
    }
}

