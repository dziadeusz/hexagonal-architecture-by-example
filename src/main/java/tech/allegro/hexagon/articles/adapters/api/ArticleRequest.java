package tech.allegro.hexagon.articles.adapters.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.allegro.hexagon.articles.domain.model.AuthorId;
import tech.allegro.hexagon.articles.domain.model.Content;
import tech.allegro.hexagon.articles.domain.model.Title;

class ArticleRequest {
    private final String title;
    private final String content;
    private final String authorId;

    ArticleRequest(@JsonProperty("title") final String title, @JsonProperty("content") final String content, @JsonProperty("authorId") final String authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }


    Title title() {
        return Title.of(title);
    }

    Content content() {
        return Content.of(content);
    }

    AuthorId authorId() {
        return AuthorId.of(authorId);
    }

}
