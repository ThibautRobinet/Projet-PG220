package board;

public class Board {

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
	Chip getChip(int line, int column);##renvoie le jeton si il exite, null sinon
	void addChip(int numeroColumn, Chip newChip),##Ajouter un jeton{
	Column mColumn = columnList[numeroColumn];
	mColumn.addChip(newChip);
}
	String toString();##Afficher la grille de jeu potentiellement custom
	void cleanBoard();
Erreurs:
	//regarder dans le sujets la tailles de la board	//erreur column pleine
    */