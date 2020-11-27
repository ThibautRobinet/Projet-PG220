package board;

import java.util.ArrayList;
import java.util.List;

import game.Symbol;

public class Board {
	private int nbColumns;
	private int nbLines;
	private List<Column> columnList;

	public static final int LEFT = 0b0001;
	public static final int RIGHT = 0b0010;
	public static final int DOWN = 0b0100;
	public static final int UP = 0b1000;

	public Board(int nbLines,int nbColumns){
		this.nbColumns = nbColumns;
		this.nbLines = nbLines;
		this.columnList = new ArrayList<>();
		for (int i = 0; i < nbColumns; i++){
			columnList.add(new Column(nbLines));
		}
	}

	public int getNbLines(){
		return this.nbLines;
	}

	public int getNbColumns(){
		return this.nbColumns;
	}

	/*public Chip getTopOfColumn(int column){
		return columnList.get(column).getTopOfColumn();
	}*/

	public Chip getChip(int line, int column){
		if (column >= 0 && column < nbColumns){
			return columnList.get(column).getChip(line);
		}
		return null;
	}


	public void addChip(int numeroColumn, Chip newChip) throws InvalidMoveException {
		if (numeroColumn < 0 || numeroColumn >= nbColumns)
			throw new InvalidMoveException();
		Column mColumn = columnList.get(numeroColumn);
		if (mColumn.isFull())
			throw new InvalidMoveException();
		mColumn.addChip(newChip);
	}

	public void cleanBoard(){
		for (int i = 0; i < nbColumns; i++){
			columnList.get(i).cleanColumn();
		}
	}

	public String toString(){
		String board = "";
		for (int l = nbLines ; l >= 0; l--){
			for (int c = 0 ; c < nbColumns ;c++){
				if (l == nbLines){
					board += (c+1)+" ";
				}
				else{
				Chip mChip = columnList.get(c).getChip(l);
				if (mChip == null)
					board += ". ";
				else
					board += mChip.getSymbol() + " ";
				}
			}
			if (l != 0)
				board += "\n";
		}
		return board;
	}

	public boolean isFull(){
		for (Column c : columnList){
			if (!c.isFull())
				return false;
		}
		return true;
	}


	public boolean isWin(int column){
		Column col = columnList.get(column);
		int line = col.getTopOfColumn();
		Chip mChip = col.getChip(line);
		if (mChip == null)
			return false;
		String s = mChip.getSymbol();
		int val;
		if ( (val = (1 + getValue(line,column-1,s,LEFT) + getValue(line,column+1,s,RIGHT) )) >= 4){
			//System.out.println("Lateral "+ val);
			return true;
		}
		if ( (val = (1 + getValue(line-1,column,s,DOWN) )) >= 4){
			//System.out.println("vertical "+ val);
			return true;
		}
		if ( (val = (1 + getValue(line-1,column-1,s,DOWN|LEFT) + getValue(line+1,column+1,s,UP|RIGHT) )) >= 4){
			//System.out.println("diag // "+ val);
			return true;
		}
		if ( (val = (1 + getValue(line+1,column-1,s,UP|LEFT) + getValue(line-1,column+1,s,DOWN|RIGHT) )) >= 4){
			//System.out.println("diag \\ "+ val);
			return true;
		}
		return false;
	}


	int getValue(int line, int column, String s, int direction){
		//System.out.println("dir: "+ direction+"| "+line+"x"+column);
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
		//System.out.println("endDir: "+ direction+"| "+line+"x"+column);
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