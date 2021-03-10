package com.example;

import com.example.entities.Article;
import com.example.entities.Price;
import com.example.entities.Supplier;
import com.example.repos.ArticleRepo;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
class OneToManyIssueTest {

    @Inject
    ArticleRepo articleRepo;

    @Test
    void test() {

        // given
        Article article = new Article("Name");

        Supplier supplier1 = new Supplier("sup1", article);
        Supplier supplier2 = new Supplier("sup2", article);

        Price price = new Price(BigDecimal.ONE, article);

        article.setSuppliers(List.of(supplier1, supplier2));
        article.setPrices(List.of(price));
        articleRepo.save(article);

        // when
        Article res = articleRepo.getById(article.getId());

        // then
        assertThat(res.getSuppliers()).hasSize(2);
        // Fails here
        assertThat(res.getPrices()).hasSize(1);
    }

}
