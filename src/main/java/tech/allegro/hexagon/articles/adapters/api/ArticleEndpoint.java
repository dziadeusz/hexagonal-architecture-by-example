package tech.allegro.hexagon.articles.adapters.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("articles")
class ArticleEndpoint {

    private final ArticleFacade articles;

    ArticleEndpoint(ArticleFacade articles) {
        this.articles = articles;
    }

    @GetMapping("{articleId}")
    ArticleResponse get(@PathVariable("articleId") final String articleId) {
        return articles.get(articleId);
    }

    @PostMapping
    ArticleIdResponse create(@RequestBody final ArticleRequest articleRequest) {
        return articles.create(articleRequest);
    }

}
