package tech.allegro.hexagon.articles.adapters.articledb;

import org.springframework.stereotype.Component;
import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.model.ArticleId;
import tech.allegro.hexagon.articles.domain.model.Author;
import tech.allegro.hexagon.articles.domain.model.Content;
import tech.allegro.hexagon.articles.domain.model.Title;
import tech.allegro.hexagon.articles.domain.ports.ArticleRepository;

import java.util.UUID;

import static tech.allegro.hexagon.articles.adapters.articledb.ArticleDatabaseModel.articleDatabaseModel;
import static tech.allegro.hexagon.articles.adapters.articledb.ArticleDatabaseModel.of;

@Component
class DbArticleRepository implements ArticleRepository {

    @Override
    public Article save(final Author author, final Title title, final Content content) {
        /**
         * Database integration implementation comes here
         */
        final ArticleDatabaseModel entity = of(author, title, content);
        return entity.toDomain();
    }

    @Override
    public Article get(final ArticleId id) {
        /**
         * Database integration implementation comes here
         */
        final ArticleDatabaseModel entity = articleDatabaseModel()
                .withId(UUID.fromString(id.value()))
                .withAuthorName("William Shakespeare")
                .withAuthorId("928467")
                .withTitle("Hexagonal Architecture")
                .withContent("Lorem ipsum")
                .build();
        return entity.toDomain();
    }
}
