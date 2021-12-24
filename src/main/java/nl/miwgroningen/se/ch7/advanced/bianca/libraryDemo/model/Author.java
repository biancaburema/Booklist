package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bianca Burema <b.burema@st.hanze.nl>
 * Schrijvers van boeken.
 */
@Entity
@Getter @Setter
public class Author {

    @Id
    @GeneratedValue
    private Long authorId;

    private String firstName;
    private String infixName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    Set<Book> booksWritten = new HashSet<>();

    public String getDisplayName() {
        return String.format("%s %s, %s", infixName, lastName, firstName);
    }
}
