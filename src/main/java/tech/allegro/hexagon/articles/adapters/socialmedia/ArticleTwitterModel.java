package tech.allegro.hexagon.articles.adapters.socialmedia;

import tech.allegro.hexagon.articles.domain.model.Article;

class ArticleTwitterModel {

    public static final String TWEET = "Check out the new article >>%s<< by %s";
    private final String twitterAccountId;
    private final String tweet;

    private ArticleTwitterModel(final String twitterAccountId, final String tweet) {
        this.twitterAccountId = twitterAccountId;
        this.tweet = tweet;
    }

    static ArticleTwitterModel of(Article article) {
        final String title = article
                .title()
                .value();
        final String twitterId = article.author().name().value();
        return new ArticleTwitterModel(twitterId, String.format(TWEET, title, twitterId));
    }

    @Override
    public String toString() {
        return tweet;
    }
}
