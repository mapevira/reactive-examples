package guru.springframework.reactiveexamples.repositories;

import guru.springframework.reactiveexamples.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.List;

class PersonRepositoryImplTest {

    PersonRepository personRepository = new PersonRepositoryImpl();

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
}