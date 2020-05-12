package tech.allegro.hexagon.articles.adapters.messagebroker;

import tech.allegro.hexagon.articles.domain.model.Article;

import java.time.ZonedDateTime;

class ArticleRetrievedMessage {

    private final Article article;

    private final ZonedDateTime sentAt;

    private ArticleRetrievedMessage(final Article article, final ZonedDateTime sentAt) {
        this.article = article;
        this.sentAt = sentAt;
    }

    static ArticleRetrievedMessage of(Article article) {
        return new ArticleRetrievedMessage(article, ZonedDateTime.now());
    }

    @Override
    public String toString() {
        return String.format("\"Article >>%s<< retrieved\"", article.title().value());
    }
}
