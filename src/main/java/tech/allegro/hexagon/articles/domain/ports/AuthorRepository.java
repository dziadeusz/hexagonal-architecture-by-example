package tech.allegro.hexagon.articles.domain.ports;

import tech.allegro.hexagon.articles.domain.model.Author;
import tech.allegro.hexagon.articles.domain.model.AuthorId;

public interface AuthorRepository {

    Author get(AuthorId authorId);
}
