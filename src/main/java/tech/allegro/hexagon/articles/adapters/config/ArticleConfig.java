package tech.allegro.hexagon.articles.adapters.config;

import tech.allegro.hexagon.articles.domain.ArticleFacade;
import tech.allegro.hexagon.articles.domain.ports.ArticleAuthorNotifier;
import tech.allegro.hexagon.articles.domain.ports.ArticleEventPublisher;
import tech.allegro.hexagon.articles.domain.ports.ArticleRepository;
import tech.allegro.hexagon.articles.domain.ports.AuthorRepository;
import tech.allegro.hexagon.articles.domain.ports.SocialMediaPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class ArticleConfig {

    @Bean
    ArticleFacade articleFacade(final ArticleRepository articleRepository,
                                final AuthorRepository authorRepository,
                                final ArticleEventPublisher eventPublisher,
                                final List<SocialMediaPublisher> socialMediaPublishers,
                                final List<ArticleAuthorNotifier> articleAuthorNotifiers) {
        return new ArticleFacade(eventPublisher, articleRepository, authorRepository, socialMediaPublishers, articleAuthorNotifiers);
    }

}
