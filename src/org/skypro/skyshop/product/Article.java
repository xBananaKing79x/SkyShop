package org.skypro.skyshop.product;

import org.skypro.skyshop.SearchEngine.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String articleName, String articleText) {
        this.title = articleName;
        this.text = articleText;
    }

    @Override
    public String getProductName() {
        return title;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Article){
            return Objects.equals(getArticleName(), ((Article) obj).getArticleName());
        } else {
            return false;
        }
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title.toLowerCase(), text.toLowerCase());
    }
}
