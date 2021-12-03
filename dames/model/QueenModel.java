package dames.model;


import dames.nutsAndBolts.PieceSquareColor;

/**
 * @author francoiseperrin
 * <p>
 * le mode de d�placement et de prise de la reine est diff�rent de celui du pion
 */
public class QueenModel extends AbstractPieceModel {
    public QueenModel(Coord coord, PieceSquareColor pieceColor) {
        super(coord, pieceColor);
    }

    //V�rifie si la pi�ce peut se d�placer ou non sur la case o� l'utilisateur clique
    @Override
    public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
        boolean ret = false;
        int colDistance = targetCoord.getColonne() - this.getColonne();
        int ligDistance = targetCoord.getLigne() - this.getLigne();
        if (Math.abs(ligDistance) == Math.abs(colDistance)) {
            ret = true;
        }
        return ret;
    }
}

