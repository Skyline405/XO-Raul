package io.raul.xo.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class FieldTest {

    @Test
    public void testGetSize() throws Exception{
        final Field field = new Field();
        assertEquals(3, field.getSIZE());
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
}