package guru.springframework.reactiveexamples.repositories;

import guru.springframework.reactiveexamples.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryImplTest {

    PersonRepository personRepository = new PersonRepositoryImpl();

    @Test
    void testGetByIdFound() {
        var personMono = personRepository.getById(3);

        assertEquals(Boolean.TRUE, personMono.hasElement().block());
    }

    @Test
    void testGetByIdNotFound() {
        var personMono = personRepository.getById(10);

        assertEquals(Boolean.FALSE, personMono.hasElement().block());
    }

    @Test
    void testGetByIdBlock() {
        var personMono = personRepository.getById(1);

        var person = personMono.block();

        System.out.println(person);
    }

    @Test
    void testGetByIdSuscriber() {
        var personMono = personRepository.getById(1);

        personMono.subscribe(System.out::println);
    }

    @Test
    void TestMapOperation() {
        var personMono = personRepository.getById(1);

        personMono.map(Person::getFirstName).subscribe(System.out::println);
    }

    @Test
    void testFluxBlockFirst() {
        var peopleFlux = personRepository.findAll();

        var person = peopleFlux.blockFirst();

        System.out.println(person);
    }

    @Test
    void testFluxSuscriber() {
        var peopleFlux = personRepository.findAll();

        peopleFlux.subscribe(System.out::println);
    }

    @Test
    void testFluxMap() {
        var peopleFlux = personRepository.findAll();

        peopleFlux.map(Person::getFirstName).subscribe(System.out::println);
    }

    @Test
    void testFluxToList() {
        var peopleFlux = personRepository.findAll();

        Mono<List<Person>> listMono = peopleFlux.collectList();

        listMono.subscribe(list -> list.forEach(person -> System.out.println(person.getFirstName())));
    }

    @Test
    void testFilterOnName() {
        var peopleFlux = personRepository.findAll();

        peopleFlux.filter(person -> person.getFirstName().equals("Fiona"))
                .subscribe(System.out::println);
    }

    @Test
    void testFilterGetById() {
        var peopleFlux = personRepository.findAll();

        Mono<Person> personMono = peopleFlux.filter(person -> person.getFirstName().equals("Fiona"))
                .next();

        personMono.subscribe(System.out::println);
    }

    @Test
    void testFindPersonByIdNotFound() {
        var peopleFlux = personRepository.findAll();

        final Integer id = 10;

        Mono<Person> personMono = peopleFlux.filter(person -> Objects.equals(person.getId(), id))
                .single()
                .doOnError(throwable -> {
                    System.out.println("Error occurred in flux");
                    System.out.println(throwable.toString());
                });

        personMono.subscribe(System.out::println, throwable -> {
            System.out.println("Error occurred in the mono");
            System.out.println(throwable.toString());
        });
    }
}