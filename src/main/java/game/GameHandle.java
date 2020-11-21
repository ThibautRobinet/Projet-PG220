package game;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import information.History;
import information.UserInterface;
import player.Player;


public class GameHandle{
	
	private final int POINTS_TO_WIN = 2;

	private Game game;
	private int numberOfPlayer;
	private List<Player> gamePlayers;

	private UserInterface mInterface;
	private History mHisto;
	

	public GameHandle(UserInterface mInterface){
		this.mInterface = mInterface;
		this.mHisto = new History();
		initGameHandle();
		//askingWhoisPlayer();
	}

	protected void initGameHandle(){
		askingNumberOfPlayers();
		createPlayers();
		askingSizeOfBoard();
	}

	private void createPlayers(){
		this.gamePlayers = new ArrayList<>();
		for (int i = 1; i <= numberOfPlayer;i++){
			Player p = new Player(i,Symbol.values()[i-1]);
			askingWhoIsPlayer(p);
			gamePlayers.add(p);
			mHisto.newPlayer(i, "humain", "Thibaut");
		}
	}

	private void askingNumberOfPlayers(){
		String message = "How many players will play ?";
		String ans = mInterface.onInputMessage(message);

		//convert ans to int 
		//deal with format error
		try {
			this.numberOfPlayer = Integer.parseInt(ans);
		}
		catch (NumberFormatException e)
		{
			mInterface.outputMessage(e.toString());
			askingNumberOfPlayers();
		}
	}

	private void askingSizeOfBoard(){
		String message = "What is the size of the Board ? (l*c)";
		String ans = mInterface.onInputMessage(message);

		String[] results = ans.split("\\*");
		if (results.length != 2){
			String error = "Two arguments are required, separate by *";
			mInterface.outputMessage(error);
			askingSizeOfBoard();
		}
		else{
			//convert results to int 
			//deal with format error
			try {
				int numberOfLines = Integer.parseInt(results[0]);
				int numberOfColumns = Integer.parseInt(results[1]);
				this.game = new Game(numberOfPlayer,new Board(numberOfLines,numberOfColumns),gamePlayers);
			}
			catch (NumberFormatException e){
				mInterface.outputMessage(e.toString());
				askingSizeOfBoard();
			}
		}
	}

	private void askingWhoIsPlayer(Player player){
		String message = "Joueur "+player.getNum()+"?";
		String ans = mInterface.onInputMessage(message);

		String[] results = ans.split(" ");
		if (results.length != 2){
			String error = "Two arguments are required, separate by space";
			mInterface.outputMessage(error);
			askingSizeOfBoard();
		}
		else{
			//convert results to int 
			//deal with format error
			if ( results[0].equals("humain") || results[0].equals("ia") ){//le premier arguments est valide

			}
			else{
				String error = "First argument must be humain or ia";
				mInterface.outputMessage(error);
				askingWhoIsPlayer(player);
			}
		}
	}

	public boolean checkIfPlayerWin(){
		for (Player p : gamePlayers){
			if (p.getScore() >= POINTS_TO_WIN){
				mInterface.outputMessage("Joueur "+ p.getNum() +" win.");
				mHisto.gameEnded();
				return true;
			}
		}
		return false;
	}

	public void nextRound(){
		Player p = game.getNextPlayerToMove();
		
		String message = "";
		String ans = mInterface.onInputMessage(message);

		//convert ans to int 
		//deal with format error
		try {
			int column = Integer.parseInt(ans);
			p.playerMove(column,game.getBoard());
			mHisto.playerMove(p.getNum(), column);
			if (game.getBoard().isWin(column)){
				p.playerWin();
				mHisto.playerWin(p.getNum());
				game.getBoard().cleanBoard();
			}
			else if (game.getBoard().isFull()){
				mHisto.playerWin(0);
				game.getBoard().cleanBoard();
			}
		}
		catch (InvalidMoveException e){
			mInterface.outputMessage(e.toString());
			nextRound();
		}
		catch (NumberFormatException e)
		{	mInterface.outputMessage("Erreur saisie colonne "+ans);
			mInterface.outputMessage(e.toString());
			nextRound();
		}

	}
}
/*
Class GameHandle
//nombre de joueurs, score, démarre et termine une manche
//tout est private
Var :
	int numberOfPlayer;
	Game game;
	UserInterface mInterface;
Constructeur
	GameHandle(UserInterface mInterface){
	askingNumberOfPlayers();
	askingSizeOfBoard();
	askingWhoisPlayer()
}
Functions :
	void askingNumberOfPlayers()
	void askingSizeOfBoard()
	void askingWhoIsPlayer(Player player)
	void checkIfPlayerWin(Game)
*/