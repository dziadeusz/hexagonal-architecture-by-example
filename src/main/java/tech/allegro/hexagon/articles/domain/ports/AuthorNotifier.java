package tech.allegro.hexagon.articles.domain.ports;

import tech.allegro.hexagon.articles.domain.model.Article;

public interface AuthorNotifier {

    void notifyAboutCreationOf(Article article);

}
