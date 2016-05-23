package io.raul.xo.model;

import io.raul.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int MIN_COORD = 0;

    private final Figure[][] field;

    private final int fieldSize;

    public Field(final int fieldSize) {
        this.field = new Figure[fieldSize][fieldSize];
        this.fieldSize = fieldSize;
    }

    public int getSize() {
        return fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if(!checkPoint(point)){
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if(!checkPoint(point)){
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point){
        return checkCoord(point.x, field.length) && checkCoord(point.y, field[point.x].length);
    }

    private boolean checkCoord(final int coord, final int maxCoord){
        return coord >= MIN_COORD && coord < maxCoord;
    }
}
