package board;

import java.util.ArrayList;
import java.util.List;

class Column {
	int nbLines;
	List<Chip> chipFilling;
	
	public Column(int nbLines){
		this.nbLines = nbLines;
		this.chipFilling = new ArrayList<>();
	}

	public void addChip (Chip NewChip){
		chipFilling.add(NewChip);
	}

	public String toString(){
		String column = "";
		for (int i = nbLines-1; i >= 0;i--){
			Chip mChip = getChip(i);
			if (mChip == null)
				column+=".\n";
			else
				column+= mChip.getSymbol() + "\n";
		}
		return column;
	}

	public int getTopOfColumn(){
		int lastChip = chipFilling.size() - 1;
		/*if (lastChip > 0)
			return chipFilling.get(lastChip);
		return null;*/
		return lastChip;
	}

	public int getNbLines(){
		return this.nbLines;
	}

	public void cleanColumn(){
		chipFilling.clear();
	}

	public boolean isFull(){
		if (this.chipFilling.size() >= this.nbLines){
			return true;
		}
		return false;
	}

	public Chip getChip(int line){
		if (line >= 0 && line < chipFilling.size()){
			return chipFilling.get(line);
		}
		return null;
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