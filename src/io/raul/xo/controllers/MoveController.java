package io.raul.xo.controllers;


import io.raul.xo.model.Field;
import io.raul.xo.model.Figure;
import io.raul.xo.model.exceptions.AlreadyOccupiedException;
import io.raul.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, final Point point, final Figure figure) throws AlreadyOccupiedException, InvalidPointException {
        if(field.getFigure(point) != null){
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
