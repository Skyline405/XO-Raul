package io.raul.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class PlayerTest {

    @Test
    public void testGetName() throws Exception {
        final String name = "Raul";
        final Player player = new Player(name, null);
        assertEquals(name, player.getName());
    }

    @Test
    public void testGetFigure() throws Exception {
        final Figure figure = Figure.O;
        final Player player = new Player(null, figure);
        assertEquals(figure, player.getFigure());
    }
}