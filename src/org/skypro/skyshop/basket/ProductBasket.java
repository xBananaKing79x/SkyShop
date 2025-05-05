package org.skypro.skyshop.basket;

import org.skypro.skyshop.SearchEngine.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products; //Массив продуктов в корзине
    //private static final int MAX_CAPACITY = 5; //Ограничение максимального объема корзины

    public ProductBasket() { //Инициализируем пустой список продуктов
        products = new ArrayList<>();
    }

    //Метод добавления продуктов в корзину
    public void addProduct(Product product) {
        if (product == null) {// Проверяем, что продукт не равен null
            System.out.println("Ошибка: невозможно добавить продукт, так как он равен null.");
            return;
        }
//        if (products.size() >= MAX_CAPACITY) {
//            System.out.println("Ошибка: корзина заполнена. Нельзя добавить больше " + MAX_CAPACITY + " продуктов.");
//            return;
//        }
        products.add(product); // Добавляем продукт в список
        System.out.println("Продукт - " + product.getSearchableName() + " добавлен в корзину.");
    }

    //Метод удаления объекта из корзины по имени
    public void removeProduct(Searchable product) {
        if (product == null) {
            System.out.println("Ошибка: невозможно удалить null-объект.");
            return;
        }

        boolean removed = products.remove(product);
        if (removed) {
            System.out.println("Продукт \"" + product + "\" удален из корзины.");
        } else {
            System.out.println("Ошибка: продукт \"" + product.getSearchableName() + "\" не найден в корзине.");
        }
    }

    // Метод удаления всех продуктов с заданным именем
    public List<Searchable> removeProductsByName(String name) {
        List<Searchable> removedProducts = new ArrayList<>(); // Список удаленных продуктов

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Searchable product = iterator.next();
            if (product.getSearchableName().equalsIgnoreCase(name)) { // Проверка имени без учета регистра
                removedProducts.add(product); // Добавляем в список удаленных
                iterator.remove(); // Удаляем из корзины
            }
        }

        if (!removedProducts.isEmpty()) {
            System.out.println("Удалено " + removedProducts.size() + " продуктов с именем \"" + name + "\".");
        } else {
            System.out.println("Продукты с именем \"" + name + "\" не найдены в корзине.");
        }
        return removedProducts; // Возвращаем список удаленных продуктов
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
