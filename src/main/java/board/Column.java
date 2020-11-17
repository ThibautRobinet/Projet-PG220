package board;

class Column {


	//doit lever une exception InvalidMoveException avec le message "erreur colonne pleine $num_column" 
	// si la colonne dans laquelle on veut ajouter un Chip est déja pleine, ie chipFilling.length() == nbLines  (avant d'ajouter le Chip)
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