package player;

import board.*;

public class IA extends Player{
	
	public IA(int numPlayer, String name,String symbPlayer){ //super: objet père -->éditer classe de base
		super(numPlayer, name, symbPlayer);
	}

	@Override
	public int playerMove(int numeroColumn, Board mBoard) throws InvalidMoveException {
		// numeroColumn n'est pas utilisé avec IA
		Chip mChip = new Chip(symbPlayer);
		int i = 1 + (int)( Math.random() * (mBoard.getNbColumns()-1) );
		mBoard.addChip(i,mChip);
		return i;
	}

	@Override
	public boolean isIA(){
		return true;
	}

}
/*
Class IA
//tout private sauf iaMove protected
Var:
	Player iaPlayer;
Constructeur:
	IA(Player mPlayer);
Functions:
	void iaMove(Board mBoard){
		//rien 
	int i = randint(mBoard.getColumn);
	iaPlayer.playerMove(i,mBoard);
	}
Erreurs:
	//erreur column pleine
*/
