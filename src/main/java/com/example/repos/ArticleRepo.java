package com.example.repos;

import com.example.entities.Article;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;

@JdbcRepository(dialect = Dialect.H2)
public interface ArticleRepo extends CrudRepository<Article, Long> {

    @Join(value = "prices", type = Join.Type.LEFT_FETCH)
    @Join(value = "suppliers", type = Join.Type.LEFT_FETCH)
    Article getById(@NotNull Long id);
}
