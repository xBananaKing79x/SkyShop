package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        //Создаем корзину
        ProductBasket basket = new ProductBasket();

        //Создаем продукты
        Product product1 = new SimpleProduct("Яблоки", 50);
        Product product2 = new SimpleProduct("Молоко",110);
        Product product3 = new FixPriceProduct("Хлеб");
        Product product4 = new FixPriceProduct("Яйца");
        Product product5 = new DiscountedProduct("Сыр",299.0,10);
        Product product6 = new SimpleProduct("Йогурт",60);


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
    }
}
