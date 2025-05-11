package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exeptions.BestResultNotFound;

import java.util.*;

import static java.awt.SystemColor.text;

public class SearchEngine {
    private Map<String, Searchable> searchables; //Коллекция для поиска

    public SearchEngine() {
        searchables = new HashMap<>();
    }

    // Метод добавления нового объекта
    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.put(searchable.getProductName(), searchable); // Добавляем объект в список
        } else {
            System.out.println("Ошибка: невозможно добавить null-объект.");
        }
    }

    // Метод поиска
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>(); // Сортировка по имени
        for (Searchable searchable : searchables.values()) {
            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.put(searchable.getProductName(), searchable);
            }
        }
        return results;
    }

    // Метод для вывода результатов поиска
    public static void printSearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }

    // Метод поиска наиболее подходящего результата
    public Searchable findBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchables.values()) {
            String searchTerm = searchable.getSearchTerm().toLowerCase();
            String query = search.toLowerCase();
            int occurrences = countOccurrences(searchTerm, query);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestResult = searchable;
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound("Не найдено результатов для запроса: " + search);
        }

        return bestResult;
    }

    // Вспомогательный метод для подсчета вхождений строки
    private int countOccurrences(String text, String query) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(query, index)) != -1) {
            count++;
            index += query.length();
        }
        return count;
    }
}

