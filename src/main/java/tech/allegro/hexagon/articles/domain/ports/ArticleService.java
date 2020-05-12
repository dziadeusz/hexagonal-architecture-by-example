package tech.allegro.hexagon.articles.domain.ports;

import tech.allegro.hexagon.articles.domain.ArticlePublisher;
import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.model.ArticleId;
import tech.allegro.hexagon.articles.domain.model.Author;
import tech.allegro.hexagon.articles.domain.model.AuthorId;
import tech.allegro.hexagon.articles.domain.model.Content;
import tech.allegro.hexagon.articles.domain.model.Title;

public final class ArticleService {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private final ArticlePublisher eventPublisher;


    public ArticleService(final ArticleRepository articleRepository,
                          final AuthorRepository authorRepository,
                          final ArticlePublisher eventPublisher) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.eventPublisher = eventPublisher;
    }

    public ArticleId create(final AuthorId authorId, final Title title, final Content content) {
        final Author author = authorRepository.get(authorId);
        final Article article = articleRepository.save(author, title, content);

        article.validateEligibilityForPublication();

        eventPublisher.publishCreationOf(article);
        return article.id();
    }

    public Article get(final ArticleId id) {
        final Article article = articleRepository.get(id);
        eventPublisher.publishRetrievalOf(article);
        return article;
    }
}
