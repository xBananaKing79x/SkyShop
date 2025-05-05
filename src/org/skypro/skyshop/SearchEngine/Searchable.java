package org.skypro.skyshop.SearchEngine;

public interface Searchable {
    String getSearchTerm(); // Термин поиска

    String getProductName();

    String getType(); // Тип контента

    String getSearchableName(); // Имя объекта
    // Дефолтный метод для строкового представления
    default String getStringRepresentation() {
        return getSearchableName() + " — " + getType();
    }

}
