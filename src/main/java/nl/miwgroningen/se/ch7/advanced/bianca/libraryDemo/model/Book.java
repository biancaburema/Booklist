package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bianca Burema <b.burema@st.hanze.nl>
 * <p>
 * Dit is een boek dat je kunt lenen in de bibliotheek.
 */

@Entity
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue
    private Long bookId;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private List<BookRead> copies;

    public int getNumberOfTimesRead() {
        int count = 0;
        for (BookRead copy : copies) {
            count += copy.isRead() ? 1 : 0;
        }
        return  count;
    }

    public String getAuthorsDisplayString() {
        StringBuilder authorsString = new StringBuilder();

        for (Author author : authors) {
            authorsString.append(" ").append(author.getDisplayName());
        }
        return authorsString.toString();
    }
}
