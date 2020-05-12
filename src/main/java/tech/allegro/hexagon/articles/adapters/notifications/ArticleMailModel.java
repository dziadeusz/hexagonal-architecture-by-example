package tech.allegro.hexagon.articles.adapters.notifications;

import tech.allegro.hexagon.articles.domain.model.Article;

class ArticleMailModel {

    private static final String SUBJECT = "You have successfully published: >>%s<<";
    private static final String CONTENT = "Check if everything is correct: >>%s<<";

    private final String recipientId;
    private final String subject;
    private final String content;

    private ArticleMailModel(final String recipientId,
                             final String subject,
                             final String content) {
        this.recipientId = recipientId;
        this.subject = subject;
        this.content = content;
    }

    static ArticleMailModel of(final Article article) {
        return new ArticleMailModel(article.author().name().value(),
                String.format(SUBJECT, article.title().value()),
                String.format(CONTENT, article.content().value()));
    }

    @Override
    public String toString() {
        return subject;
    }
}
