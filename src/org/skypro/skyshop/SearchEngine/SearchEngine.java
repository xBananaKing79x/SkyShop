package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exeptions.BestResultNotFound;

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
    public Searchable findBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchables) {
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

