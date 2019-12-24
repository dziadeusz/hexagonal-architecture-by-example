package tech.allegro.hexagon.articles.adapters.twitter;

import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.ports.SocialMediaPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class TwitterArticlePublisher implements SocialMediaPublisher {

    private final Logger log = LoggerFactory.getLogger(TwitterArticlePublisher.class);


    @Override
    public void publish(final Article article) {
        /**
         * social media integration implementation  using {@link TwitterModel} comes here
         */
        log.info("Article: \"{}\" published on twitter", article.title().value());
    }
}
