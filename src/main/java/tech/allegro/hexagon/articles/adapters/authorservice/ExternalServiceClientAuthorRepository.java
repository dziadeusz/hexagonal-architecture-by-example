package tech.allegro.hexagon.articles.adapters.authorservice;

import tech.allegro.hexagon.articles.domain.model.Author;
import tech.allegro.hexagon.articles.domain.model.AuthorId;
import tech.allegro.hexagon.articles.domain.model.PersonName;
import tech.allegro.hexagon.articles.domain.ports.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class ExternalServiceClientAuthorRepository implements AuthorRepository {
    private final Logger log = LoggerFactory.getLogger(ExternalServiceClientAuthorRepository.class);

    @Override
    public Author get(final AuthorId authorId) {
        /**
         * external author service integration implementation comes here
         */
        log.info("Author: \"William Shakespeare\" fetched", authorId.value());
        return Author
                .author()
                .withId(authorId)
                .withName(PersonName.of("William Shakespeare"))
                .build();
    }
}
