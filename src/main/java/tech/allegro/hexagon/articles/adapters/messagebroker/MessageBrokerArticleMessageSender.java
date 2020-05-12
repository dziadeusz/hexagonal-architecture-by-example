package tech.allegro.hexagon.articles.adapters.messagebroker;

import org.springframework.stereotype.Component;
import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.ports.ArticleMessageSender;

@Component
class MessageBrokerArticleMessageSender implements ArticleMessageSender {

    @Override
    public void sendMessageForCreated(final Article article) {
        /**
         * message broker integration implementation comes here
         */
        ArticleCreatedMessage.of(article);
    }

    @Override
    public void sendMessageForRetrieved(final Article article) {
        /**
         * message broker integration implementation comes here
         */
        ArticleRetrievedMessage.of(article);
    }
}
