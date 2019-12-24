package tech.allegro.hexagon.articles.domain.ports;

import tech.allegro.hexagon.articles.domain.model.Article;

public interface ArticleEventPublisher {

    void publishArticleCreationEvent(Article article);

    void publishArticleRetrievalEvent(Article article);

}
