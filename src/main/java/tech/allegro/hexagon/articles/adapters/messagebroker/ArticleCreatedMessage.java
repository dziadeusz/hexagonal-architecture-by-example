package tech.allegro.hexagon.articles.adapters.messagebroker;

import tech.allegro.hexagon.articles.domain.model.Article;

import java.time.ZonedDateTime;

class ArticleCreatedMessage {

    private final Article article;
    private final ZonedDateTime sentAt;

    private ArticleCreatedMessage(final Article article, final ZonedDateTime sentAt) {
        this.article = article;
        this.sentAt = sentAt;
    }

    static ArticleCreatedMessage of(Article article) {
        return new ArticleCreatedMessage(article, ZonedDateTime.now());
    }

    @Override
    public String toString() {
        return String.format("\"Article >>%s<< created\"", article.title().value());
    }
}
