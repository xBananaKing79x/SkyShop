package org.skypro.skyshop.SearchEngine;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        // Сравнение по длине имени
        int lengthComparison = Integer.compare(s1.getProductName().length(), s2.getProductName().length());
        if (lengthComparison != 0) {
            return -lengthComparison; // От большего к меньшему (по убыванию)
        }
        // Если длины равны, сравниваем в натуральном порядке
        return s1.getProductName().compareToIgnoreCase(s2.getProductName());
    }
}
