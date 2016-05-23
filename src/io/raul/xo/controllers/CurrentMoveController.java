package io.raul.xo.controllers;


import io.raul.xo.model.Field;
import io.raul.xo.model.Figure;
import io.raul.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field){
        int countFigures = 0;

        for (int x = 0; x < field.getSize(); x++) {
            countFigures += countFiguresInRow(field, x);
        }

        if(countFigures == field.getSize() * field.getSize()){
            return null;
        }

        if(countFigures % 2 == 0){
            return Figure.X;
        }

        return Figure.O;
    }

    private int countFiguresInRow(final Field field, int row){
        int countFigures = 0;
        for (int y = 0; y < field.getSize(); y++) {
            try {
                if(field.getFigure(new Point(row, y)) != null){
                    countFigures++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigures;
    }

}
