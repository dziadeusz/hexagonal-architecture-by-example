package tech.allegro.hexagon.articles.domain.ports;

import tech.allegro.hexagon.articles.domain.model.Article;

public interface SocialMediaPublisher {

    void publish(Article article);

}
