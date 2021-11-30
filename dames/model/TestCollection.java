package jeux_dames.model;


import java.util.*;

import jeux_dames.nutsAndBolts.PieceSquareColor;

/**
 * @author francoise.perrin
 * 
 
 */
public class TestCollection {

	public static void main(String[] args) {
		
		// la collection de pi�ces en jeu - m�lange noires et blanches
		Collection<PieceModel> pieces1 = null ;
	
		
		/* Impl�mentation de la Collection par une LinkedList 
		
		* Remplissage 
		* Affichage selon l'ordre d'insertion dans collection - 5 pi�ces par ligne
		* Puis tests de diff�rents algos de tri avec affichage
		* */
		pieces1 = new LinkedList<PieceModel>();
		pieces1 = fillCollection(pieces1);
		System.out.println("Affichage LinkedList selon l'ordre d'insertion dans collection");
		System.out.println(getRender(pieces1));
		
//		TestSortList(pieces); // Test de tri de la liste impl�ment�e par une LinkedList
//
//		
//		/* Impl�mentation de la Collection par une ArrayList 
//		
//		* Remplissage 
//		* Affichage selon l'ordre d'insertion dans collection
//		* Puis tests de diff�rents algos de tri avec affichage
//		* */
		// la collection de pi�ces en jeu - m�lange noires et blanches
		Collection<PieceModel> pieces2 = null ;

		pieces2 = new ArrayList<PieceModel>();
		pieces2 = fillCollection(pieces2);
		System.out.println("\nAffichage ArrayList selon l'ordre d'insertion dans collection");
		System.out.println(getRender(pieces2));
		TestSortList(pieces2);
//		
//		/* Impl�mentation de la Collection par un HashSet  
//		
//		* Remplissage 1 s�rie de pions blancs et de pions noirs
//		*    puis 2 s�ries de pions noirs
//		* Affichage selon l'ordre d'insertion dans collection 
//		*    <-- KO avant MAJ classe AbstractPiece
//		* Puis tests tri <-- KO
//		* */
		// la collection de pi�ces en jeu - m�lange noires et blanches
		Collection<PieceModel> pieces3 = null ;


		pieces3 = new HashSet<PieceModel>();
		pieces3 = fillCollection(pieces3);
		System.out.println("\nAffichage HashSet selon l'ordre d'insertion dans collection");
		System.out.println(getRender(pieces3));
		// Collections.sort((Set<PieceModel>) pieces); // --> KO compilation : pas tri sur Set
//	
//		
//		/* Impl�mentation de la Collection par un TreeSet  
//
		Collection<PieceModel> pieces4 = null ;

//		* Remplissage 
//		* Affichage selon l'ordre d'insertion dans collection 
//		* */
		pieces4 = new TreeSet<PieceModel>(new PieceComparator());
		pieces4 = fillCollection(pieces4);
		System.out.println("\nAffichage TreeSet selon l'ordre d'insertion dans collection");
		System.out.println(getRender(pieces4));
	}
	private static Collection<PieceModel> fillCollection(Collection<PieceModel> pieces) {
		
		// Cr�ation des pion blancs et ajout dans la collection de pi�ces
		for ( Coord coord : ModelConfig.WHITE_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.WHITE));
		}

		// Cr�ation des pions noirs et ajout dans la collection de pi�ces
		for ( Coord coord : ModelConfig.BLACK_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.BLACK));
		}

		//	// Cr�ation des pions noirs et ajout � nouveau dans la collection de pi�ces
		//  // Utile pour v�rifier pb hashcode sur les hashSet
		//	for ( Coord coord : ModelConfig.BLACK_PIECE_COORDS){
		//		pieces.add(new PawnModel(coord, PieceSquareColor.BLACK));
		//	}

		return pieces;
	}

	private static void TestSortList(Collection<PieceModel> pieces) {

		// Affichage dans ordre croissant des cases sur le damier (de 0 � 99)
		// Tri selon ordre naturel des PieceModel
		Collections.sort((List<PieceModel>) pieces);
		System.out.println("Affichage selon l'ordre croissant des cases");
		System.out.println(getRender(pieces));

		// Affichage dans ordre croissant des col puis des lignes
		// Tri avec un autre comparateur
		Collections.sort((List<PieceModel>)pieces, new PieceComparator());
		System.out.println("Affichage selon l'ordre croissant des col puis des lignes");
		System.out.println(getRender(pieces));
	}
	
	private static String getRender(Collection<PieceModel> pieces) {
		String st = "";
		int i = 0;
		
		// Parcours collection en utilisant un it�rateur ou un ListIterator
		while(pieces.iterator().hasNext()){
			st += pieces.iterator();
			if (i++%5 == 0){ st += "\n"; }
			i++;
		}
		return st;	
	}
}

class PieceComparator implements Comparator<PieceModel>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * Permet de comparer en 1er sur les colonnes puis sur les lignes
	 */
	@Override
	public int compare (PieceModel o1, PieceModel o2) {
		int comp = 0;
		if (o1.getColonne() > o2.getColonne()) {
			comp = (int) Math.signum(o1.getColonne());
		} else if(o1.getColonne() < o2.getColonne()) {
			comp = (int) Math.signum(o2.getColonne());
		}

		if(comp == 0) {
			comp = o1.getLigne()-o2.getLigne();
		} else {
			comp = o1.getColonne() - o2.getColonne();
		}
		return comp;
	}
}


