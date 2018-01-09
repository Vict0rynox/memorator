package org.victorynox.memorator.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Simple VO which point visual
 *
 * @author victorynox
 * @version 0.1
 */
@Embeddable
public class Point implements Serializable {

    /**
     * Coordinate x (width)
     */
    private int x;

    /**
     * Coordinate x (width)
     */
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
