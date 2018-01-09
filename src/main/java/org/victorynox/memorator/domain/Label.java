package org.victorynox.memorator.domain;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author victorynox
 * @version 0.1
 */
@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private Mem mem;

    private Point point;

    private Phrase phrase;

    public Label(Mem mem, Point point, Phrase phrase) {
        this.point = point;
        this.phrase = phrase;
    }

    public Label() {
    }

    public Point getPoint() {
        return point;
    }

    public Phrase getPhrase() {
        return phrase;
    }
}
