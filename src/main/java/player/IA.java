package player;

import information.UserInterface;

public class IA extends Player{
	
	int numberOfColumns;
	
	public IA(int numPlayer, String name,String symbPlayer,int numOfCol){ //super: objet père -->éditer classe de base
		super(numPlayer, name, symbPlayer);
		this.numberOfColumns = numOfCol;
	}

	@Override
	public int play(UserInterface mInterface,double[] board){
		int i = (int)( Math.random() * (numberOfColumns) );
		return i;
	}
}
