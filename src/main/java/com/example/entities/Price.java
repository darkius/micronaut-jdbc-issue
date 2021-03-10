package com.example.entities;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@MappedEntity("prices")
public class Price {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private BigDecimal value;

    @NotNull
    @Relation(value = Relation.Kind.MANY_TO_ONE)
    private Article article;

    public Price(@NotNull BigDecimal value, @NotNull Article article) {
        this.value = value;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
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
        Price price = (Price) o;
        return id.equals(price.id) && value.equals(price.value) && article.equals(price.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, article);
    }
}
