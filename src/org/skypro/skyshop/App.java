package org.skypro.skyshop;

import org.skypro.skyshop.Exeptions.BestResultNotFound;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.SearchEngine.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.skypro.skyshop.SearchEngine.SearchEngine.printSearchResults;

public class App {
    public static void main(String[] args) {
        //Создаем корзину
        ProductBasket basket = new ProductBasket();
        // Создаем движок поиска
        SearchEngine searchEngine = new SearchEngine();
        //Создаем продукты
        try {
            // Неправильные данные
            Product invalidProduct1 = new SimpleProduct("", 100); // Пустое имя
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product invalidProduct2 = new SimpleProduct("Яблоки", 0); // Нулевая цена
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product invalidProduct3 = new DiscountedProduct("Молоко", 100, 150); // Скидка больше 100
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Product product1 = new SimpleProduct("Яблоки", 50);
        Product product2 = new SimpleProduct("Молоко", 110);
        Product product3 = new FixPriceProduct("Хлеб");
        Product product4 = new FixPriceProduct("Яйца");
        Product product5 = new DiscountedProduct("Сыр", 299.0, 10);
        Product product6 = new SimpleProduct("Йогурт", 60);
        //Добавляем товары в движок поиска
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        //Создаем статьи
        Article article1 = new Article("Как выбрать яблоки", "Статья о том, как правильно выбирать яблоки.");
        Article article2 = new Article("Польза молока (молоко)", "Статья о пользе молока для здоровья.");
        Article article3 = new Article("Влияние хлеба на фигуру", "Статья о том как хлеб влияет на фигуру");
        // Добавляем статьи в движок поиска
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        //Добавляем продукты в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        //Добавляем продукт в заполненную корзину
        basket.addProduct(product6);//Продукт "Йогурт" не будет добавлен, в корзине нет места, в консоли не увидим строки с добавлением продукта
        basket.printProductBasket();//Печать содержимого корзины
        System.out.println(basket.getTotalCost()); //Печать стоимости продуктов корзины
        System.out.println(basket.containsProductByName("молоко"));//Поиск товара, который есть в корзине
        System.out.println(basket.containsProductByName("йогурт"));//Поиск товара, которого нет в корзине
        System.out.println("Удаляем яблоки");
        basket.removeProduct(product1);
        // Пытаемся удалить несуществующий объект
        System.out.println("Удаляем 'Окрошку':");
        basket.removeProduct(new SimpleProduct("Окрошка", 200.0));
        System.out.println("Печатаем корзину:");
        basket.printProductBasket();
        basket.clearProductBasket();//Очистка корзины
        basket.printProductBasket();//Печать содержимого пустой корзины
        System.out.println(basket.getTotalCost()); //Печать стоимости продуктов корзины
        System.out.println(basket.containsProductByName("молоко"));//Поиск товара в пустой корзине
        try {
            // Успешный поиск
            Searchable result = searchEngine.findBestResult("яблоки");
            System.out.println("Наиболее подходящий результат: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            // Поиск без результата
            Searchable result = searchEngine.findBestResult("несуществующий запрос");
            System.out.println("Наиболее подходящий результат: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // Поиск с использованием нового метода
        System.out.println("\nРезультаты поиска по запросу 'яблоки':");
        Set<Searchable> searchResults = searchEngine.search("яблоки");
        for (Searchable results : searchResults) {
            System.out.println(searchResults);
        }
    }
}


