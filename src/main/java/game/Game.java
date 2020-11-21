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

	public boolean isWin(int column){
		int line = gameBoard.getTopOfColumn(column);
		Chip mChip = gameBoard.getChip(line,column);
		Symbol s = mChip.getSymbol();
		if ( (1 + gameBoard.getValue(line,column-1,s,Board.LEFT) + gameBoard.getValue(line,column+1,s,Board.RIGHT) ) >= 4)
			return true;
		if ( (1 + gameBoard.getValue(line-1,column,s,Board.DOWN) ) >= 4)
			return true;
		if ( (1 + gameBoard.getValue(line-1,column-1,s,Board.DOWN|Board.LEFT) + gameBoard.getValue(line+1,column+1,s,Board.UP|Board.RIGHT) ) >= 4)
			return true;
		if ( (1 + gameBoard.getValue(line-+1,column-1,s,Board.UP|Board.LEFT) + gameBoard.getValue(line-1,column+1,s,Board.DOWN|Board.RIGHT) ) >= 4)
			return true;
		return false;
	}
}
/*
Class Game
//tout private
Var:
	int numberOfPlayer;
	Board gameBoard
	List<Player> gamePlayer;
	int nextPlayerToMove

Constructeur:
	Game(int numberOfPlayer, Board mBoard);
Functions:
	int getNumOfPlayerPlayer();
	void playerHadPlayed();##Change the value of nextPlayerToMove
	Player getNextPlayerToMove(); 
	public boolean isAWinner()##remarque de pilou le best, appelé la function seulement quand a joueur a joué 4fois
	public void resetBoard();
Erreurs:
	//erreur column pleine
*/