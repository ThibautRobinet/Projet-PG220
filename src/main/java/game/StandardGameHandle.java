package game;

import information.UserInterface;
import board.StandardBoard;
import board.Board;

public class StandardGameHandle extends GameHandle {

	
	public StandardGameHandle(UserInterface mInterface) {
		super(mInterface);
	}
 
	@Override
	protected void initGameHandle(){
		super.numberOfPlayer = 2;
		createPlayers();
		Board mBoard = new StandardBoard();
		super.game = new Game(numberOfPlayer, mBoard,super.gamePlayers);
	}

}
/*
//nombre de joueurs, score, démarre et termine une manche
//tout est private
Var:
Constructeur
	GameHandle(UserInterface mInterface){
	numberOfPlayer = 2;
	Board mBoard = new StandardBoard();
	this.game = new Game(numberOfPlayer, mBoard);
	askingWhoIsPlayer() / peut être a déplacer dans le constructeur du player /
}
Functions :
	void askingNumberOfPlayers()
	void askingSizeOfBoard()
	void askingWhoIsPlayer(Player player)
*/