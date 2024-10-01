package guru.springframework.reactiveexamples.repositories;

import guru.springframework.reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 01/10/2024 - 08:26
 * @since jdk 1.17
 */
public class PersonRepositoryImpl implements PersonRepository {

    Person michael = Person.builder().id(1).firstName("Michael").lastName("Weston").build();
    Person fiona = Person.builder().id(2).firstName("Fiona").lastName("Glenanne").build();
    Person sam = Person.builder().id(3).firstName("Sam").lastName("Axe").build();
    Person jesse = Person.builder().id(4).firstName("Jesse").lastName("Porter").build();

    /**
     * Retrieves a person entity by its unique identifier.
     *
     * @param id The unique identifier of the person to retrieve.
     * @return A {@link Mono} emitting the person entity with the given identifier,
     * or an empty {@link Mono} if no person with the given identifier exists.
     */
    @Override
    public Mono<Person> getById(final Integer id) {
        return findAll().filter(person -> person.getId().equals(id)).next();
    }

    /**
     * Retrieves all person entities.
     *
     * @return A {@link Flux} emitting all person entities.
     */
    @Override
    public Flux<Person> findAll() {
        return Flux.just(michael, fiona, sam, jesse);
    }

}
