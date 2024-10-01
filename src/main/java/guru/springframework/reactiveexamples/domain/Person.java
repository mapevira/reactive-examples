package guru.springframework.reactiveexamples.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a person with an id, first name, and last name.
 *
 * <p>This class is a simple domain object used in the reactive examples project.
 * It uses Lombok annotations to generate boilerplate code such as getters, setters,
 * constructors, and the builder pattern.</p>
 *
 * <p>Annotations used:</p>
 * <ul>
 *   <li>@Data - Generates getters, setters, toString, equals, and hashCode methods.</li>
 *   <li>@Builder - Implements the builder pattern for object creation.</li>
 *   <li>@AllArgsConstructor - Generates a constructor with all fields as parameters.</li>
 *   <li>@NoArgsConstructor - Generates a no-argument constructor.</li>
 * </ul>
 *
 * <p>Created by jt, Spring Framework Guru.</p>
 *
 * @author architecture - rperezv
 * @version 01/10/2024 - 08:16
 * @since jdk 1.17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    /**
     * The unique identifier for the person.
     */
    private Integer id;

    /**
     * The first name of the person.
     */
    private String firstName;

    /**
     * The last name of the person.
     */
    private String lastName;

}
