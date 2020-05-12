package tech.allegro.hexagon.articles.adapters.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.allegro.hexagon.articles.domain.model.ArticleId;

class ArticleIdResponse {

    private final String id;

    private ArticleIdResponse(final String id) {
        this.id = id;
    }

    static ArticleIdResponse of(final ArticleId articleId) {
        return new ArticleIdResponse(articleId.value());
    }

    @JsonProperty("id")
    String id() {
        return id;
    }

}
