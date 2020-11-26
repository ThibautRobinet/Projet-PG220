package board;

class Column {
	int nbLines;
	List<Chip> chipFilling;
	
	public Column(int nbLines){
		this.nbLines = nbLines;
	}

	void addChip (Chip NewChip){
		chipFilling.append(Chip);
	}

	String toString(){
		if (chipFilling =! null){
			return Symbol;
		}
		if (chipFilling == null){
			return ".";
		}

	}

	int getNbLines(){
		return this.nbLines;
	}

	void cleanColumn(){
		return 0;
	}

	bool isFull(){
		if (size(chipFilling)>this.nbLines){
			return true;
		}
	}
}



	//doit lever une exception InvalidMoveException avec le message "erreur colonne pleine $num_column" 
	// si la colonne dans laquelle on veut ajouter un Chip est déja pleine, ie chipFilling.length() == nbLines  (avant d'ajouter le Chip)

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
	bool isFull();##Renvoie true si la colonne est pleine
Erreurs:
    la taille de chipFilling < nbLines;
    */