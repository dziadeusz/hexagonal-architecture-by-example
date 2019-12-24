package tech.allegro.hexagon.articles.domain.ports;

import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.model.ArticleId;
import tech.allegro.hexagon.articles.domain.model.Author;
import tech.allegro.hexagon.articles.domain.model.Content;
import tech.allegro.hexagon.articles.domain.model.Title;

public interface ArticleRepository {

    Article save(Author author, Title title, Content content);

    Article get(ArticleId id);
}
