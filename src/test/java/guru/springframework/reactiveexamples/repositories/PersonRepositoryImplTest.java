package guru.springframework.reactiveexamples.repositories;

import guru.springframework.reactiveexamples.domain.Person;
import org.junit.jupiter.api.Test;

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
}