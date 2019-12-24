package tech.allegro.hexagon.articles.domain.ports;

import tech.allegro.hexagon.articles.domain.model.Article;

public interface ArticleAuthorNotifier {

    void notifyAboutArticleCreation(Article article);

}
