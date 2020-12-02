package game;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.InvalidMoveException;
import information.History;
import information.UserInterface;
import player.Player;
import player.IA;


public class GameHandle{
	
	protected int POINTS_TO_WIN = 2;

	protected Game game;
	protected int numberOfPlayer;
	protected List<Player> gamePlayers;

	protected UserInterface mInterface;
	private History mHisto;
	

	public GameHandle(UserInterface mInterface){
		this.mInterface = mInterface;
		this.mHisto = new History();
		initGameHandle();
	}

	protected void initGameHandle(){
		askingNumberOfPlayers();
		createPlayers();
		askingSizeOfBoard();
		System.out.println(game.getBoard().toString());
	}

	protected void createPlayers(){
		this.gamePlayers = new ArrayList<>();
		for (int i = 1; i <= numberOfPlayer;i++){
			Player p = askingWhoIsPlayer(i,Symbol.values()[i-1]);
			gamePlayers.add(p);
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

	private Player askingWhoIsPlayer(int num, Symbol s){
		String message = "Joueur "+num+"?";
		String ans = mInterface.onInputMessage(message);

		String[] results = ans.split(" ");
		if (results.length != 2){
			String error = "Two arguments are required, separate by space";
			mInterface.outputMessage(error);
			return askingWhoIsPlayer(num,s);
		}
		else{
			//convert results to int 
			//deal with format error
			if ( results[0].equals("humain") ){//le premier arguments est valide
				mHisto.newPlayer(num, "humain", results[1]);
				return new Player(num,results[1],s.getSymbol());
			}
			else if ( results[0].equals("ia") ){
				mHisto.newPlayer(num, "ia", results[1]);
				return new IA(num,results[1],s.getSymbol());
			}
			else{
				String error = "First argument must be humain or ia";
				mInterface.outputMessage(error);
				return askingWhoIsPlayer(num,s);
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
		String ans = "0";
		if( !p.isIA())
			ans = mInterface.onInputMessage(message);

		
		//convert ans to int 
		//deal with format error
		try {
			int column = Integer.parseInt(ans) ;
			int res = p.playerMove(column,game.getBoard());
			mHisto.playerMove(p.getNum(),res +1);
			game.playerHadPlayed();
			System.out.println(game.getBoard().toString());
			if (game.getBoard().isWin(res)){
				p.playerWin();
				mHisto.playerWin(p.getNum());
				mHisto.playersScore(gamePlayers);
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
		catch (NumberFormatException e){
			mInterface.outputMessage("Erreur saisie colonne "+ans);
			mInterface.outputMessage(e.toString());
			nextRound();
		}
		
	}
}
