package tech.allegro.hexagon.articles.domain.ports;

import tech.allegro.hexagon.articles.domain.model.Article;

public interface ArticleMessageSender {

    void sendMessageForCreated(Article article);

    void sendMessageForRetrieved(Article article);

}
