package io.raul.xo.model;

import io.raul.xo.model.exceptions.AlreadyOccupiedException;
import io.raul.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class FieldTest {

    @Test
    public void testGetSize() throws Exception{
        final Field field = new Field();
        assertEquals(3, field.getSize());
    }

    @Test
    public void testGetFigure() throws Exception {

    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field();
        final Point point = new Point(0,0);
        final Figure figure = Figure.O;

        field.setFigure(point, figure);
        assertEquals(figure, field.getFigure(point));
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point point = new Point(0,0);

        assertNull(field.getFigure(point));
    }

    @Test
    public void testGetFigureWhenXLessThenZero() throws Exception {
        final Field field = new Field();
        final Point point = new Point(-1,0);

        try {
            field.getFigure(point);
            fail();
        }catch (final InvalidPointException e){

        }
    }

    @Test
    public void testGetFigureWhenYLessThenZero() throws Exception {
        final Field field = new Field();
        final Point point = new Point(0,-1);

        try {
            field.getFigure(point);
            fail();
        }catch (final InvalidPointException e){

        }
    }

    @Test
    public void testGetFigureWhenXMoreThenMax() throws Exception {
        final Field field = new Field();
        final Point point = new Point(field.getSize()+1, 0);

        try {
            field.getFigure(point);
            fail();
        }catch (final InvalidPointException e){

        }
    }

    @Test
    public void testGetFigureWhenYMoreThenMax() throws Exception {
        final Field field = new Field();
        final Point point = new Point(0,field.getSize()+1);

        try {
            field.getFigure(point);
            fail();
        }catch (final InvalidPointException e){

        }
    }

    @Test
    public void testSetFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point point = new Point(0,0);
        final Figure figure = Figure.O;

        field.setFigure(point, figure);

        try {
            field.setFigure(point, figure);
            fail();
        }catch (final AlreadyOccupiedException e){

        }
    }
}