package player;

import board.Board;

class IA extends Player{
	
	public IA(int numPlayer, String name,String symbPlayer){ //super: objet père -->éditer classe de base
		super(numPlayer, name, symbPlayer);
	}

	@Override
	protected void playerMove(Board mBoard) {
		int i = randint(mBoard.getColumn());
		mBoard.addChip(i,mChip);
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
