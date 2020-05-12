package tech.allegro.hexagon.articles.adapters.socialmedia;

import org.springframework.stereotype.Component;
import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.ports.SocialMediaPublisher;

@Component
class TwitterArticlePublisher implements SocialMediaPublisher {

    private final TwitterClient twitterClient;

    TwitterArticlePublisher(final TwitterClient twitterClient) {
        this.twitterClient = twitterClient;
    }

    @Override
    public void publish(final Article article) {
        final ArticleTwitterModel articleTweet = ArticleTwitterModel.of(article);
        twitterClient.tweet(articleTweet);
    }
}
