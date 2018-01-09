package org.victorynox.memorator.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Value Object
 *
 * @author victorynox
 * @version 0.1
 */
@Embeddable
public class Phrase {

    /**
     * Phrase test
     */
    private String phrase;

    public Phrase(String text) {
        this.phrase = text;
    }

    public Phrase() {
    }

    public String getPhrase() {
        return phrase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phrase phrase1 = (Phrase) o;
        return Objects.equals(phrase, phrase1.phrase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phrase);
    }
}
