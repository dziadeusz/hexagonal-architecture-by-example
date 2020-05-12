package tech.allegro.hexagon.articles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.allegro.hexagon.articles.domain.ArticlePublisher;
import tech.allegro.hexagon.articles.domain.ports.ArticleMessageSender;
import tech.allegro.hexagon.articles.domain.ports.ArticleRepository;
import tech.allegro.hexagon.articles.domain.ports.ArticleService;
import tech.allegro.hexagon.articles.domain.ports.AuthorNotifier;
import tech.allegro.hexagon.articles.domain.ports.AuthorRepository;
import tech.allegro.hexagon.articles.domain.ports.SocialMediaPublisher;

import java.util.List;

@Configuration
class ArticleConfig {

    @Bean
    ArticlePublisher articleEventPublisher(final ArticleMessageSender eventPublisher,
                                           final List<SocialMediaPublisher> socialMediaPublishers,
                                           final List<AuthorNotifier> articleAuthorNotifiers) {
        return new ArticlePublisher(eventPublisher,
                socialMediaPublishers,
                articleAuthorNotifiers);
    }

    @Bean
    ArticleService articleService(final ArticleRepository articleRepository,
                                  final AuthorRepository authorRepository,
                                  final ArticlePublisher articleEventPublisher
    ) {
        return new ArticleService(
                articleRepository,
                authorRepository,
                articleEventPublisher);
    }

}
