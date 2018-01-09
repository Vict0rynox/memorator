package org.victorynox.memorator.domain;

import org.victorynox.memorator.domain.exception.InvalidPhrasePositionException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Aggregate
 *
 * @author victorynox
 * @version 0.1
 */
@Entity
public class Mem {

    /**
     * Mem identity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    /**
     * Mem image
     */
    @ManyToOne
    private Image image;
    @OneToMany(targetEntity = Label.class, mappedBy = "mem")
    @MapKey(name = "id")
    private Set<Label> labelSet;

    //need for JPA
    protected Mem() {
    }

    /**
     * Mem with image
     *
     * @param image mem basic image
     */
    public Mem(Image image) {
        labelSet = new HashSet<>();
        this.image = image;
    }

    /**
     * Add phrase to mem
     */
    public void addLabel(Label label) throws InvalidPhrasePositionException {
        //validate
        if (isInvalidPosition(label.getPoint())) {
            throw new InvalidPhrasePositionException(label.getPoint());
        }

        this.labelSet.add(label);
    }

    /**
     * Check if phrase position is valid
     *
     * @param point validated phrase position
     * @return true if position is valid
     */
    private boolean isInvalidPosition(Point point) {
        return point.getY() >= image.getHeight() || point.getY() < 0 ||
                point.getX() >= image.getWidth() || point.getX() < 0;
    }

    /**
     * Bake all phrase on image, by that generate mem.
     *
     * @return {@code Image} with bake mem
     */
    public Image bakeMem() {
        Image mem = new Image(image.getWidth(), image.getHeight());
        for (Label label : labelSet) {
            image.addPhrase(label.getPoint(), label.getPhrase());
        }
        return mem;
    }
}
