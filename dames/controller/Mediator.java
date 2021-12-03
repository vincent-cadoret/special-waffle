package dames.controller;

import dames.gui.View;
import dames.model.BoardGame;
import dames.model.Coord;

/**
 * @author francoise.perrin
 * Le Controller fait le lien entre laView et le Model
 * qui ne se connaissent pas
 */
public interface Mediator {

    void setView(View view);

    void setModel(BoardGame<Coord> model);
}
