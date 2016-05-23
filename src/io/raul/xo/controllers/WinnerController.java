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
                if(check(field, new Point(0, i), new IPointChanger() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.x + 1, point.y);
                    }
                })){
                    return field.getFigure(new Point(0, i));
                }
            }

            if(check(field, new Point(0, 0), new IPointChanger() {
                @Override
                public Point next(Point point) {
                    return new Point(point.x + 1, point.y + 1);
                }
            })){
                return field.getFigure(new Point(0, 0));
            }

            if(check(field, new Point(0, 2), new IPointChanger() {
                @Override
                public Point next(Point point) {
                    return new Point(point.x + 1, point.y - 1);
                }
            })){
                return field.getFigure(new Point(0, 0));
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point startPoint, final IPointChanger pointChanger){
        Point p1 = startPoint;
        Point p2 = pointChanger.next(p1);
        Point p3 = pointChanger.next(p2);

        try {
            if(field.getFigure(p1) == null){
                return false;
            }
            if (field.getFigure(p1) == field.getFigure(p2)
                    && field.getFigure(p1) == field.getFigure(p3)){
                return true;
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static interface IPointChanger {
        Point next(final Point point);
    }

}
