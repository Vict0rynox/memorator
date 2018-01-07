package org.victorynox.memorator.domain;

import java.util.List;

/**
 * Aggregate
 * @author victorynox
 * @version 0.1
 */
public class Mem {

    private final Image image;

    private List<Phrase> prhases;

    public Mem(Image image) {
        this.image = image;
    }

    /**
     * Add phrase to mem
     */
    public void addPhrase(Phrase phrase) {
        this.prhases.add(phrase);
    }
}
