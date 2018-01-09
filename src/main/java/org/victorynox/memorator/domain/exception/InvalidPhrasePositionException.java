package org.victorynox.memorator.domain.exception;

import org.victorynox.memorator.domain.Point;

import java.text.MessageFormat;

/**
 * Exception
 * If point is not valid position on image
 * @author victorynox
 * @version 0.1
 */
public class InvalidPhrasePositionException extends Exception {
    public InvalidPhrasePositionException() {
    }

    public InvalidPhrasePositionException(Point point) {
        super(MessageFormat.format("Point {0} is invalid.", point.toString()));
    }
}
