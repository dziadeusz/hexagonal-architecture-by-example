package tech.allegro.hexagon.articles.adapters.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.allegro.hexagon.articles.domain.model.Article;

class ArticleResponse {
    private final String id;
    private final String title;
    private final String content;
    private final String authorName;

    private ArticleResponse(final String id, final String title, final String content, final String authorName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorName = authorName;
    }

    static ArticleResponse of(final Article article) {
        return new ArticleResponse(article.id().value(),
                article.title().value(),
                article.content().value(),
                article.author().name().value());
    }

    @JsonProperty("id")
    String id() {
        return id;
    }

    @JsonProperty("title")
    String title() {
        return title;
    }

    @JsonProperty("content")
    String content() {
        return content;
    }

    @JsonProperty("authorName")
    String authorName() {
        return authorName;
    }
}
