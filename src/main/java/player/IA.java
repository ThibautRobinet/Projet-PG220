package player;

import board.Board;

class IA{
	Player iaPlayer;

	IA(Player mPlayer);

	protected void iaMove(Board mBoard) {
		int i = randint(mBoard.getColumn);
		iaPlayer.playerMove(i,mBoard);
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
