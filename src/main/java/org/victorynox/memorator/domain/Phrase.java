package org.victorynox.memorator.domain;

/**
 * Value Object
 * @author victorynox
 * @version 0.1
 */
public class Phrase {

    /**
     * Phrase test
     */
    private final String phrase;

    public Phrase(String text) {
        this.phrase = text;
    }

    public String getPhrase() {
        return phrase;
    }
}
