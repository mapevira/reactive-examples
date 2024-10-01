package guru.springframework.reactiveexamples.repositories;

import guru.springframework.reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository interface for managing {@link Person} entities.
 *
 * <p>This interface provides methods for retrieving person entities
 * using reactive programming paradigms provided by Project Reactor.</p>
 *
 * <p>Created by jt, Spring Framework Guru.</p>
 *
 * @author architecture - raulp
 * @version 01/10/2024 - 08:22
 * @since jdk 1.21
 */
public interface PersonRepository {

    /**
     * Retrieves a person entity by its unique identifier.
     *
     * @param id The unique identifier of the person to retrieve.
     * @return A {@link Mono} emitting the person entity with the given identifier,
     *         or an empty {@link Mono} if no person with the given identifier exists.
     */
    Mono<Person> getById(Integer id);

    /**
     * Retrieves all person entities.
     *
     * @return A {@link Flux} emitting all person entities.
     */
    Flux<Person> findAll();

}
