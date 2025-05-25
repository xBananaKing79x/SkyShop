package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exeptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

import static java.awt.SystemColor.text;

public class SearchEngine {
    private Set<Searchable> searchables; //множество для поиска

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    // Метод добавления нового объекта
    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable); // Добавляем объект в список
        } else {
            System.out.println("Ошибка: невозможно добавить null-объект.");
        }
    }

// Метод поиска с использованием Stream API
public Set<Searchable> search(String query) {
    return searchables.stream()
            .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase()))
            .collect(Collectors.toCollection(() ->
                    new TreeSet<>(new SearchableComparator()) // Создаем TreeSet с компаратором
            ));
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

