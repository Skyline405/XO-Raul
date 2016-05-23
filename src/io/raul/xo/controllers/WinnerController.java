package io.raul.xo.controllers;

import io.raul.xo.model.Field;
import io.raul.xo.model.Figure;
import io.raul.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field){
        try {
            for (int i = 0; i < field.getSize(); i++) {
                if(check(field, new Point(i, 0), point -> new Point(point.x, point.y + 1))){
                    return field.getFigure(new Point(i, 0));
                }
            }

            for (int i = 0; i < field.getSize(); i++) {
                if(check(field, new Point(0, i), point -> new Point(point.x + 1, point.y))){
                    return field.getFigure(new Point(0, i));
                }
            }

            if(check(field, new Point(0, 0), point -> new Point(point.x + 1, point.y + 1))){
                return field.getFigure(new Point(0, 0));
            }

            if(check(field, new Point(0, 2), point -> new Point(point.x + 1, point.y - 1))){
                return field.getFigure(new Point(0, 2));
            }
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator){
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nexPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);

            if(currentFigure == null){
                return false;
            }

            nextFigure = field.getFigure(nexPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if(currentFigure != nextFigure){
            return false;
        }

        return check(field, nexPoint, pointGenerator);
    }

    private interface IPointGenerator {
        Point next(final Point point);
    }

}
