package org.skypro.skyshop.product;

import org.skypro.skyshop.SearchEngine.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String articleName, String articleText) {
        this.title = articleName;
        this.text = articleText;
    }

    public String getArticleName() {
        return title;
    }

    public String getArticleText() {
        return text;
    }
    //Переопределяем метод toString
    @Override
    public String toString() {
        return title + "\n" + text;
    }

    //Переопределяем методы интерфейса Searchable
    @Override
    public String getSearchTerm() {
        return title + "\n" + text;
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getSearchableName() {
        return getArticleName();
    }
}
