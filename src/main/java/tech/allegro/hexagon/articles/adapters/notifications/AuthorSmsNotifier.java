package tech.allegro.hexagon.articles.adapters.notifications;

import org.springframework.stereotype.Component;
import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.ports.AuthorNotifier;

@Component
class AuthorSmsNotifier implements AuthorNotifier {

    @Override
    public void notifyAboutCreationOf(final Article article) {
        /**
         * SMS system integration implementation comes here
         */
        ArticleSmsModel.of(article);
    }
}
