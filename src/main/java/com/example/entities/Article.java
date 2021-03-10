package com.example.entities;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@MappedEntity("articles")
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "article", cascade = Relation.Cascade.ALL)
    private List<Price> prices;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "article", cascade = Relation.Cascade.ALL)
    private List<Supplier> suppliers;

    public Article(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id) && name.equals(article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
