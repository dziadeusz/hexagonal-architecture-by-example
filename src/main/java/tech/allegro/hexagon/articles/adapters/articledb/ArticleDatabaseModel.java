package tech.allegro.hexagon.articles.adapters.articledb;

import tech.allegro.hexagon.articles.domain.model.Article;
import tech.allegro.hexagon.articles.domain.model.ArticleId;
import tech.allegro.hexagon.articles.domain.model.Author;
import tech.allegro.hexagon.articles.domain.model.AuthorId;
import tech.allegro.hexagon.articles.domain.model.Content;
import tech.allegro.hexagon.articles.domain.model.PersonName;
import tech.allegro.hexagon.articles.domain.model.Title;

import java.time.ZonedDateTime;
import java.util.UUID;

class ArticleDatabaseModel {

    private final UUID id;
    private final String title;
    private final String content;
    private final long version;
    private final ZonedDateTime createdAt;
    private final String authorId;
    private final String authorName;

    private ArticleDatabaseModel(final UUID id,
                                 final String title,
                                 final String content,
                                 final String authorId,
                                 final long version,
                                 final ZonedDateTime createdAt,
                                 final String authorName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.version = version;
        this.createdAt = createdAt;
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return title;
    }

    Article toDomain() {
        return Article.article()
                .withId(ArticleId.of(id.toString()))
                .withAuthor(Author
                        .author()
                        .withId(AuthorId.of(authorId))
                        .withName(PersonName.of(authorName))
                        .build())
                .withTitle(Title.of(title))
                .withContent(Content.of(content))
                .build();
    }

    static ArticleDatabaseModel of(final Author author, final Title title, final Content content) {
        return articleDatabaseModel()
                .withId(UUID.randomUUID())
                .withVersion(0)
                .withCreatedAt(ZonedDateTime.now())
                .withAuthorId(author.id().value())
                .withAuthorName(author.name().value())
                .withTitle(title.value())
                .withContent(content.value())
                .build();
    }

    static ArticleDatabaseModelBuilder articleDatabaseModel() {
        return new ArticleDatabaseModelBuilder();
    }

    static final class ArticleDatabaseModelBuilder {
        private UUID id;
        private String title;
        private String content;
        private long version;
        private ZonedDateTime createdAt;
        private String authorId;
        private String authorName;

        private ArticleDatabaseModelBuilder() {
        }

        ArticleDatabaseModelBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        ArticleDatabaseModelBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        ArticleDatabaseModelBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        ArticleDatabaseModelBuilder withVersion(long version) {
            this.version = version;
            return this;
        }

        ArticleDatabaseModelBuilder withCreatedAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        ArticleDatabaseModelBuilder withAuthorId(String authorId) {
            this.authorId = authorId;
            return this;
        }

        ArticleDatabaseModelBuilder withAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        ArticleDatabaseModel build() {
            return new ArticleDatabaseModel(id, title, content, authorId, version, createdAt, authorName);
        }
    }
}
