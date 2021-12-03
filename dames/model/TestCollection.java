package dames.model;
import dames.nutsAndBolts.PieceSquareColor;
import java.util.*;

public class TestCollection {
    public static void main (String[] args) {
        Collection<PieceModel> pieces;

        pieces = new LinkedList<>();
        pieces = fillCollection(pieces);
        System.out.println("Affichage LinkedList selon l'ordre d'insertion dans collection");
        System.out.println(getRender(pieces));

		pieces = new ArrayList<>();
		pieces = fillCollection(pieces);
		System.out.println("\nAffichage ArrayList selon l'ordre d'insertion dans collection");
		System.out.println(getRender(pieces));
		TestSortList(pieces);

		pieces = new HashSet<>();
		pieces = fillCollection(pieces);
		System.out.println("\nAffichage HashSet selon l'ordre d'insertion dans collection");
		System.out.println(getRender(pieces));

		pieces = new TreeSet<>(new PieceComparator());
		pieces = fillCollection(pieces);
		System.out.println("\nAffichage TreeSet selon l'ordre d'insertion dans collection");
		System.out.println(getRender(pieces));
    }

    private static Collection<PieceModel> fillCollection (Collection<PieceModel> pieces) {
        for (Coord coord : ModelConfig.WHITE_PIECE_COORDS) {
            pieces.add(new PawnModel(coord, PieceSquareColor.WHITE));
        }
        for (Coord coord : ModelConfig.BLACK_PIECE_COORDS) {
            pieces.add(new PawnModel(coord, PieceSquareColor.BLACK));
        }
        for (Coord coord : ModelConfig.BLACK_PIECE_COORDS) {
            pieces.add(new PawnModel(coord, PieceSquareColor.BLACK));
        }
        return pieces;
    }

    private static void TestSortList (Collection<PieceModel> pieces) {
		System.out.println("Affichage selon l'ordre croissant des cases");
		System.out.println(getRender(pieces));

		Collections.sort((List<PieceModel>)pieces, new PieceComparator());
		System.out.println("Affichage selon l'ordre croissant des col puis des lignes");
		System.out.println(getRender(pieces));
    }

    private static String getRender(Collection<PieceModel> pieces) {
        String temp = "";
        Iterator<PieceModel> it = pieces.iterator();
        while (it.hasNext()) {
            temp += it.next();
        }
        return temp;
    }
}

class PieceComparator implements Comparator<PieceModel> {
    @Override
    public int compare(PieceModel objet1, PieceModel objet2) {
        int comp = 0;
        if (objet1.getColonne() > objet2.getColonne()) {
            comp = (int) Math.signum(objet1.getColonne());
        } else if (objet1.getColonne() < objet2.getColonne()) {
            comp = (int) Math.signum(objet2.getColonne());
        }

        if (comp == 0) {
            comp = objet1.getLigne() - objet2.getLigne();
        } else {
            comp = objet1.getColonne() - objet2.getColonne();
        }
        return comp;
    }
}


