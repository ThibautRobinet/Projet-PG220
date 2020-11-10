package main.java.board;

class Column {
}
/*
Class Column
//tout est private
Var:
	int nbLines;
	List<Chip> chipFilling;
Constructeur:
	Column(int nbLines);
Functions:
	void addChip(Chip newChip);##Ajouter le jeton a chipFilling
	String toString(); ##Affiche la ligne | mettre le symbole du jeton si yen a un et “.” sinon
	int getNbLines(); ## renvoie le nombre de ligne remplie dans cette colonne
	void cleanColumn();
Erreurs:
    la taille de chipFilling < nbLines;
    */