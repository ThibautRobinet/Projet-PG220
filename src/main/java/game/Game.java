package game;

import java.util.List;

import board.Board;
import player.Player;

public class Game{

	int numberOfPlayer;
	Board gameBoard;
	List<Player> gamePlayers;
	int nextPlayerToMove;

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
		if (isAWinner()){
			gameBoard.cleanBoard();
		}
	}

	private boolean isAWinner(){
		for (Player p : gamePlayers){
			if (/*condition pour que p gagne*/){
				p.winGame();
				return true;
			}
		}
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