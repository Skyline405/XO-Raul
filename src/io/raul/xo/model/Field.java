package io.raul.xo.model;


import java.awt.*;

public class Field {

    private final int SIZE = 3;

    private final Figure[][] field = new Figure[SIZE][SIZE];

    public int getSIZE() {
        return SIZE;
    }

    public Figure getFigure(final Point point) {
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure){
        field[point.x][point.y] = figure;
    }
}
