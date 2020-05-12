package tech.allegro.hexagon.articles.adapters.notifications;

import org.springframework.stereotype.Component;
import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.ports.AuthorNotifier;

@Component
class AuthorMailNotifier implements AuthorNotifier {

    @Override
    public void notifyAboutCreationOf(final Article article) {
        /**
         * Mail system integration implementation comes here
         */
        ArticleMailModel.of(article);
    }
}
