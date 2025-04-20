package org.skypro.skyshop;

import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.SearchEngine.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //Создаем корзину
        ProductBasket basket = new ProductBasket();
        // Создаем движок поиска
        SearchEngine searchEngine = new SearchEngine();
        //Создаем продукты
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
        basket.clearProductBasket();//Очистка корзины
        basket.printProductBasket();//Печать содержимого пустой корзины
        System.out.println(basket.getTotalCost()); //Печать стоимости продуктов корзины
        System.out.println(basket.containsProductByName("молоко"));//Поиск товара в пустой корзине
        System.out.println("Поиск по запросу 'яблоки'");
        System.out.println(Arrays.toString(searchEngine.search("яблоки")));
        System.out.println("Поиск по запросу 'молоко'");
        System.out.println(Arrays.toString(searchEngine.search("молоко")));
        System.out.println("Поиск по запросу 'хлеб'");
        System.out.println(Arrays.toString(searchEngine.search("хлеб")));
    }
}


