package game;

import java.util.List;

import board.Board;
import board.Chip;
import player.Player;


public class Game{

	private int numberOfPlayer;
	private Board gameBoard;
	private List<Player> gamePlayers;
	private int nextPlayerToMove;

	Game(int numberOfPlayer, Board mBoard, List<Player> gamePlayers){
		this.numberOfPlayer = numberOfPlayer;
		this.gameBoard = mBoard;
		this.gamePlayers = gamePlayers;
	}
	
	public int getNumOfPlayers(){
		return this.numberOfPlayer;
	}

	public Player getNextPlayerToMove(){
		return gamePlayers.get(nextPlayerToMove);
	}

	public Board getBoard(){
		return this.gameBoard;
	}

	public void playerHadPlayed(){
		nextPlayerToMove ++;
		if (nextPlayerToMove >= numberOfPlayer){
			nextPlayerToMove = 0;
		}
	}
}