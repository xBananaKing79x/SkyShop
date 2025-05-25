package org.skypro.skyshop.basket;

import org.skypro.skyshop.SearchEngine.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Searchable>> products; //"Карта" продуктов в корзине
    //private static final int MAX_CAPACITY = 5; //Ограничение максимального объема корзины

    public ProductBasket () {
        products = new HashMap<>();
    }

    //Метод добавления продуктов в корзину
    public void addProduct(Searchable product) {
        if (product == null) {
            System.out.println("Ошибка: невозможно добавить null-объект.");
            return;
        }
        String name = product.getProductName();
        products.putIfAbsent(name, new ArrayList<>());
        products.get(name).add(product);
        System.out.println("Продукт \"" + name + "\" добавлен в корзину.");
    }

    //Метод удаления объекта из корзины по имени
    public List<Searchable> removeProductsByName(String name) {
        List<Searchable> removedProducts = products.remove(name); // Удаляем весь список продуктов с таким именем
        if (removedProducts != null && !removedProducts.isEmpty()) {
            System.out.println("Удалено " + removedProducts.size() + " продуктов с именем \"" + name + "\".");
        } else {
            System.out.println("Продукты с именем \"" + name + "\" не найдены в корзине.");
        }
        return removedProducts != null ? removedProducts : Collections.emptyList();
    }

    // Метод удаления конкретного объекта из корзины
    public boolean removeProduct(Searchable product) {
        if (product == null) {
            System.out.println("Ошибка: невозможно удалить null-объект.");
            return false;
        }
        String name = product.getProductName();
        List<Searchable> productList = products.get(name);
        if (productList == null || productList.isEmpty()) {
            System.out.println("Ошибка: продукт \"" + name + "\" не найден в корзине.");
            return false;
        }
        boolean removed = productList.remove(product); // Удаляем объект из списка
        if (removed) {
            System.out.println("Продукт \"" + name + "\" удален из корзины.");
            if (productList.isEmpty()) {
                products.remove(name); // Удаляем ключ, если список пуст
            }
        } else {
            System.out.println("Ошибка: продукт \"" + name + "\" не найден в корзине.");
        }
        return removed;
    }

    // Метод подсчета количества специальных продуктов
    public long countSpecialProducts() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Searchable::isSpecial)
                .count();
    }

    //Метод получения общей стоимости продуктов корзины
    public double getTotalCost() {
        return products.values().stream()
                .flatMap(Collection::stream) // Преобразуем Stream<List<Product>> в Stream<Product>
                .filter(Product.class::isInstance)
                .mapToDouble(product -> ((Product) product).getProductPrice())
                .sum();
    }

    // Метод для вывода всех продуктов в корзине
    public void printProductBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(product-> System.out.println(product.getStringRepresentation()));
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Количество специальных продуктов: " + countSpecialProducts());
    }

    public boolean containsProductByName(String productName) {
        return products.values().stream() // Получаем поток списков продуктов
                .flatMap(Collection::stream) // Преобразуем Stream<List<Searchable>> в плоский Stream<Searchable>
                .anyMatch(product -> product.getProductName().equalsIgnoreCase(productName)); // Проверяем, есть ли продукт с указанным именем
    }

    public void clearProductBasket() {
        products.clear(); // Очищаем массив продуктов корзины
        System.out.println("Корзина очищена.");
    }
}
