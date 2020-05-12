package tech.allegro.hexagon.articles.adapters.api;

import org.springframework.stereotype.Component;
import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.model.ArticleId;
import tech.allegro.hexagon.articles.domain.ports.ArticleService;

@Component
class ArticleFacade {

    private final ArticleService articleService;

    ArticleFacade(final ArticleService articleService) {
        this.articleService = articleService;
    }

    ArticleResponse get(final String articleId) {
        final Article article = articleService.get(ArticleId.of(articleId));
        return ArticleResponse.of(article);
    }

    ArticleIdResponse create(final ArticleRequest articleRequest) {
        final ArticleId articleId = articleService.create(articleRequest.authorId(), articleRequest.title(), articleRequest.content());
        return ArticleIdResponse.of(articleId);
    }
}
