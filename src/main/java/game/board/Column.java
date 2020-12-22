package game.board;

import java.util.ArrayList;
import java.util.List;

final class Column {
	private final int nbLines;
	private List<Chip> chipFilling;
	
	Column(int nbLines){
		this.nbLines = nbLines;
		this.chipFilling = new ArrayList<>();
	}

	void addChip (Chip NewChip){
		chipFilling.add(NewChip);
	}

	int getTopOfColumn(){
		int lastChip = chipFilling.size() - 1;
		return lastChip;
	}

	int getNbLines(){
		return this.nbLines;
	}

	void cleanColumn(){
		chipFilling.clear();
	}

	boolean isFull(){
		if (this.chipFilling.size() >= this.nbLines){
			return true;
		}
		return false;
	}

	Chip getChip(int line){
		if (line >= 0 && line < chipFilling.size()){
			return chipFilling.get(line);
		}
		return null;
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
}