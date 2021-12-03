package dames.gui;

import dames.nutsAndBolts.PieceSquareColor;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * @author francoiseperrin
 * <p>
 * Classe d'affichage des carr�s du damier
 * leur couleur est initialis� par les couleurs par d�faut du jeu
 */
class SquareGui extends BorderPane implements CheckersSquareGui {

    private final PieceSquareColor squareColor;            // le carr� est Noir ou Blanc

    public SquareGui(PieceSquareColor squareColor) {
        super();
        this.squareColor = squareColor;

        // la couleur est d�finie par les valeurs par d�faut de configuration
        Color color = PieceSquareColor.BLACK.equals(this.squareColor) ?
                GuiConfig.CASEBLACK : GuiConfig.CASEWHITE;

        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }


    /**
     * Retourne l'indice du carr� sur la grille (N� de 0 � 99)
     */
    @Override
    public int getSquareCoord() {
        int index = -1;
        Pane parent = (Pane) this.getParent();
        index = parent.getChildren().indexOf(this);
        return index;
    }

}
