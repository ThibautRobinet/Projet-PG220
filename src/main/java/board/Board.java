package board;

import game.Symbol;

public class Board {
	int nbColumns;
	int nbLines;
	List<Column> columnList;

	public static final int LEFT = 0b0001;
	public static final int RIGHT = 0b0010;
	public static final int DOWN = 0b0100;
	public static final int UP = 0b1000;

	Board(int nbLines,int nbColumns ){
		this.nbColums = nbColumns;
		this.nbLines = nbLines;
		this.columnList = new ArrayList<>();
		For (int I = 0; I< nbcolumn){
			columnList.append(new Column(nbLines));
		}
	}

	int getNbLines(){
		return this.nbLines;
	}
	int getNbColumns(){
		return this.nbColumns;
	}
	int getTopOfColumn(int column){
		return;
	}
	Chip getChip(int line, int column){
		if (size(mboard.chipFilling)=!0){
			return Chip;
		}
		if (size(mboard.chipFilling)==0){
			return null;
		}
	}


	void addChip(int numeroColumn, Chip newChip){
		Column mColumn = columnList[numeroColumn];
		mColumn.addChip(newChip);
	}

	String toString(){
		return Board;
	}
	void cleanBoard(){
		For (int I = 0; I< nbcolumn){
			mColumn.cleanColumn(columnList[I]);
		}
		return 0;
	}

	bool isFull(){
		if (size(mBoard.chipFilling)>this.nbLines){
			return true;
		}
	}

}


	public boolean isWin(int column){
		int line = getTopOfColumn(column);
		Chip mChip = getChip(line,column);
		Symbol s = mChip.getSymbol();
		if ( (1 + getValue(line,column-1,s,LEFT) + getValue(line,column+1,s,RIGHT) ) >= 4)
			return true;
		if ( (1 + getValue(line-1,column,s,DOWN) ) >= 4)
			return true;
		if ( (1 + getValue(line-1,column-1,s,DOWN|LEFT) + getValue(line+1,column+1,s,UP|RIGHT) ) >= 4)
			return true;
		if ( (1 + getValue(line-+1,column-1,s,UP|LEFT) + getValue(line-1,column+1,s,DOWN|RIGHT) ) >= 4)
			return true;
		return false;
	}


	int getValue(int line, int column, Symbol s, int direction){
		int l = line;
		int c = column;
		Chip mChip = getChip(line,column);
		if (mChip == null)
			return 0;
		if (!mChip.getSymbol().equals(s)){
			return 0;
		}
		switch(direction&1100){
			case DOWN:
				l--;
				break;
			case UP:
				l++;
				break;
		}
		int filtre = 0b0011;
		switch(direction&filtre){
			case LEFT:
				c--;
				break;
			case RIGHT:
				c++;
				break;
		}
		return 1 + getValue(l, c, s, direction);
	}
	//doit lever une exception InvalidMoveException avec le message "erreur colonne non valide $num_column" 
	// si le numero de column passé en args a add chip est < 0 ou > nbColumns
}
/*abstractClass Board 
//tout qui est private sauf toString protected
Var:
	int nbColumns;
	int nbLines;
	List<Column> columnList;
	
Constructeur:
	Board(int nbLines,int nbColumns ){
		this.nbColums = nbColumns;
		this.nbLines = nbLines;
		this.columnList = new ArrayList<>();
		For (int I = 0; I< nbcolumn){
			columnList.append(new Column(nbLines));
		}
	}
Functions:
	int getNbLines();
	int getNbColumns();
	int getTopOfColumn(int column);## renvoie le nombre de lignes remplies dans cette colonne
	Chip getChip(int line, int column);##renvoie le jeton si il exite, null sinon

	void addChip(int numeroColumn, Chip newChip){,##Ajouter un jeton
		Column mColumn = columnList[numeroColumn];
		mColumn.addChip(newChip);
	}
	String toString();##Afficher la grille de jeu potentiellement custom
	void cleanBoard();
	bool isFull();##Renvoie true si la colonne est pleine
Erreurs:
	//regarder dans le sujets la tailles de la board	//erreur column pleine
    */