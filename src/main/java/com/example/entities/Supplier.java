package com.example.entities;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@MappedEntity("suppliers")
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String value;

    @NotNull
    @Relation(value = Relation.Kind.MANY_TO_ONE)
    private Article article;

    public Supplier(@NotNull String value, @NotNull Article article) {
        this.value = value;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id.equals(supplier.id) && value.equals(supplier.value) && article.equals(supplier.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, article);
    }
}
