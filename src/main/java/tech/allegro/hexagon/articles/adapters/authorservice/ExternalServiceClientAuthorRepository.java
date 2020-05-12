package tech.allegro.hexagon.articles.adapters.authorservice;

import org.springframework.stereotype.Component;
import tech.allegro.hexagon.articles.domain.model.Author;
import tech.allegro.hexagon.articles.domain.model.AuthorId;
import tech.allegro.hexagon.articles.domain.ports.AuthorRepository;

import static tech.allegro.hexagon.articles.adapters.authorservice.AuthorExternalModel.authorExternalModel;

@Component
class ExternalServiceClientAuthorRepository implements AuthorRepository {


    @Override
    public Author get(final AuthorId authorId) {
        /**
         * external author service integration implementation comes here
         */
        final AuthorExternalModel author = authorExternalModel()
                .withId(928467)
                .withFirstName("William")
                .withLastName("Shakespeare")
                .build();
        return author.toDomain();
    }
}
