package game;

import java.util.List;
import player.Player;
import game.board.*;


final class Game{

	private final Board gameBoard;
	private final List<Player> gamePlayers;
	private int nextPlayerToMove;

	Game(Board mBoard, List<Player> gamePlayers){
		this.gameBoard = mBoard;
		this.gamePlayers = gamePlayers;
	}
	
	int getNumOfPlayers(){
		return gamePlayers.size();
	}

	Player getNextPlayerToMove(){
		return gamePlayers.get(nextPlayerToMove);
	}

	Board getBoard(){
		return this.gameBoard;
	}

	void playerHadPlayed(){
		nextPlayerToMove ++;
		if (nextPlayerToMove >= gamePlayers.size()){
			nextPlayerToMove = 0;
		}
	}
}