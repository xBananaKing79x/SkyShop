package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private List<Product> products; //Массив продуктов в корзине
    private static final int MAX_CAPACITY = 5; //Ограничение максимального объема корзины

    public ProductBasket() { //Инициализируем пустой список продуктов
        products = new ArrayList<>();
    }

    //Метод добавления продуктов в корзину
    public void addProduct(Product product) {
        if (product == null) {// Проверяем, что продукт не равен null
            System.out.println("Ошибка: невозможно добавить продукт, так как он равен null.");
            return;
        }
        if (products.size() >= MAX_CAPACITY) {
            System.out.println("Ошибка: корзина заполнена. Нельзя добавить больше " + MAX_CAPACITY + " продуктов.");
            return;
        }
        products.add(product); // Добавляем продукт в список
        System.out.println("Продукт - " + product.getProductName() + " добавлен в корзину.");
    }

    // Метод подсчета количества специальных продуктов
    public int countSpecialProducts() {
        int count = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    //Метод получения общей стоимости продуктов корзины
    public double getTotalCost() {
        double totalCost = 0;//Переменная для хранения общей стоимости
        for (Product Product : products) {
            totalCost += Product.getProductPrice(); //Суммируем цены всех продуктов в корзине
        }
        return totalCost;
    }

    // Метод для вывода всех продуктов в корзине
    public void printProductBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + countSpecialProducts());
        }
    }

    public boolean containsProductByName(String productName) {
        for (Product Product : products) {
            if (Product.getProductName().equalsIgnoreCase(productName)) { // Сравнение без учета регистра
                return true; // Продукт найден
            }
        }
        return false; // Продукт не найден
    }

    public void clearProductBasket() {
        products.clear(); // Очищаем массив продуктов корзины
        System.out.println("Корзина очищена.");
    }
}
