package board;

public class StandardBoard extends Board {
	public StandardBoard(){
		super(6,7);
}
	/*@Override
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
	}*/
}

	