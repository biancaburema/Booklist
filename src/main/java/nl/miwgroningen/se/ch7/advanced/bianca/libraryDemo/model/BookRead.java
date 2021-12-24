package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Bianca Burema <b.burema@st.hanze.nl>
 * <p>
 * Dit is een exemplaar van een boek.
 */

@Entity
@Getter @Setter
public class BookRead {

    @Id
    @GeneratedValue
    private Long bookReadId;

    @ManyToOne
    private Book book;

    private boolean read = true;
}
