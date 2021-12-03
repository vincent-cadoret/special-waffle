package dames.gui;

import dames.nutsAndBolts.PieceSquareColor;
import javafx.scene.image.Image;

/**
 * @author francoise.perrin
 * Cette interface permet de v�rifier qu'un Node
 * est fonctionnellement une pi�ce du jeu
 * <p>
 * Lorsque le pion du model est promu en dame
 * le visuel change
 * <p>
 * La m�thode hasSameColorAsGamer sera utilise en mode Client/server
 * pour emp�cher un joueur de jouer une pi�ce qui ne lui appartient pas
 */
public interface CheckersPieceGui {

    void promote(Image image);

    boolean hasSameColorAsGamer(PieceSquareColor gamerColor);
}
