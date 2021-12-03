package dames.gui;

import dames.nutsAndBolts.PieceSquareColor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * @author francoise.perrin
 * <p>
 * Cette classe permet de donner une image aux pi�ces
 */

public class PieceGui extends ImageView implements CheckersPieceGui {

    private final PieceSquareColor color;

    public PieceGui(Image image, PieceSquareColor color) {

        this.color = color;
        this.setImage(image);
    }

    @Override
    public boolean hasSameColorAsGamer(PieceSquareColor gamerColor) {
        return this.color.equals(gamerColor);
    }

    @Override
    public void promote(Image image) {
        this.setImage(image);
    }


}