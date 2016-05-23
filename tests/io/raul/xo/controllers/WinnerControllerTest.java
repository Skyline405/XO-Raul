package io.raul.xo.controllers;

import io.raul.xo.model.Field;
import io.raul.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Skyline on 23.05.2016.
 */
public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinRow() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinRow() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinRow2() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.O);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.X);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinCol() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinCol() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,2), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,2), Figure.O);
        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(2,0), Figure.O);
        assertNull(winnerController.getWinner(field));
    }
}