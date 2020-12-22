package game.board;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private final int nbColumns;
	private final int nbLines;
	private final List<Column> columnList;

	private final int LEFT = 0b0001;
	private final int RIGHT = 0b0010;
	private final int DOWN = 0b0100;
	private final int UP = 0b1000;

	public Board(int nbLines,int nbColumns){
		this.nbColumns = nbColumns;
		this.nbLines = nbLines;
		this.columnList = new ArrayList<>();
		for (int i = 0; i < nbColumns; i++){
			columnList.add(new Column(nbLines));
		}
	}
	
	Chip getChip(int line, int column){
		if (column >= 0 && column < nbColumns){
			return columnList.get(column).getChip(line);
		}
		return null;
	}

	int getValue(int line, int column, String s, int direction){
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
	
	public void addChip(int numeroColumn, String symbol, int numOfPlayer) throws InvalidMoveException {
		if (numeroColumn < 0 || numeroColumn >= nbColumns)
			throw new InvalidMoveException("Erreur colonne non valide " + (numeroColumn+1));
		Column mColumn = columnList.get(numeroColumn);
		if (mColumn.isFull())
			throw new InvalidMoveException("Erreur colonne pleine " + (numeroColumn+1));
		Chip newChip = new Chip(symbol,numOfPlayer);
		mColumn.addChip(newChip);
	}

	public int getNbLines(){
		return this.nbLines;
	}

	public int getNbColumns(){
		return this.nbColumns;
	}

	public void cleanBoard(){
		for (int i = 0; i < nbColumns; i++){
			columnList.get(i).cleanColumn();
		}
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
			return true;
		}
		if ( (val = (1 + getValue(line-1,column,s,DOWN) )) >= 4){
			return true;
		}
		if ( (val = (1 + getValue(line-1,column-1,s,DOWN|LEFT) + getValue(line+1,column+1,s,UP|RIGHT) )) >= 4){
			return true;
		}
		if ( (val = (1 + getValue(line+1,column-1,s,UP|LEFT) + getValue(line-1,column+1,s,DOWN|RIGHT) )) >= 4){
			return true;
		}
		return false;
	}


	public double[] toDoubles() {
		double[] board = new double[nbColumns*nbLines];;
		for (int l = nbLines-1; l >= 0; l--) {
			for (int c = 0; c < nbColumns; c++) {
				
				int i = (nbLines-1-l)*nbColumns +c;
				//System.out.println(l+":"+c+"=>"+i);
				Chip mChip = columnList.get(c).getChip(l);
				if (mChip == null)
					board[i] = Double.parseDouble("0");
				else
					board[i]= Double.valueOf(mChip.getOwnerPlayerNum());			
			}
		}
		return board;
	}

	public String toLineString(int numPlayer) {
		String i = String.valueOf(numPlayer);
		String board = "";
		for (int l = nbLines-1; l >= 0; l--) {
			for (int c = 0; c < nbColumns; c++) {
				Chip mChip = columnList.get(c).getChip(l);
				if (mChip == null)
					board += 0;
				else{
					String s = mChip.getSymbol();	
					if (s.equals(i)){
						board += 1;
					}else{
						board += 2;
					}
				}
			}
		}
		return board;
	}

	public String toString() {
		String board = "";
		for (int l = nbLines; l >= 0; l--) {
			for (int c = 0; c < nbColumns; c++) {
				if (l == nbLines) {
					board += (c + 1) + " ";
				} else {
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
}
