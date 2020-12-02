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
		System.out.println(game.getBoard().toString());
	}

}
