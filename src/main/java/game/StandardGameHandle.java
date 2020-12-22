package game;

import information.UserInterface;
import game.board.*;

public final class StandardGameHandle extends GameHandle {

	public StandardGameHandle(UserInterface mInterface) throws QuitException{
		super(mInterface);
	}
 
	@Override
	final void initGameHandle()throws QuitException{
		this.numberOfPlayer = 2;
		Board mBoard = new StandardBoard();
		this.game = new Game(mBoard,this.gamePlayers);
		createPlayers();
		mHisto.newManche();
	}

}
