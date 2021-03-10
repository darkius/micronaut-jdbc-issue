package com.example.entities;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@MappedEntity("articles")
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "article", cascade = Relation.Cascade.ALL)
    private Set<Price> prices;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "article", cascade = Relation.Cascade.ALL)
    private Set<Supplier> suppliers;

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

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
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
