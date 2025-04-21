package org.skypro.skyshop.SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables; //Коллекция для поиска

    public SearchEngine() {
        searchables = new ArrayList<>();
    }

    // Метод добавления нового объекта
    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable); // Добавляем объект в список
        } else {
            System.out.println("Ошибка: невозможно добавить null-объект.");
        }
    }

    // Метод поиска
    public Searchable[] search(String query) {
        ArrayList<Searchable> results = new ArrayList<>(); // Список для хранения результатов
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(searchable); // Добавляем найденный объект в результаты
                if (results.size() == 5) { // Если найдено 5 результатов, завершаем поиск
                    break;
                }
            }
        }
        // Преобразуем список результатов в массив
        Searchable[] resultArray = new Searchable[results.size()];
        return results.toArray(resultArray);
    }
    // Метод для вывода результатов поиска
    public static void printSearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }
}

