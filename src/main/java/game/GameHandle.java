package game;

import java.util.ArrayList;
import java.util.List;

import game.board.*;
import information.History;
import information.UserInterface;
import player.Player;
import player.IA;


public class GameHandle{
	
	int POINTS_TO_WIN = 2;
	Game game;
	int numberOfPlayer;
	List<Player> gamePlayers;
	UserInterface mInterface;
	History mHisto;
	private boolean alreadyPrint = false;

	public GameHandle(UserInterface mInterface)throws QuitException{
		this.mInterface = mInterface;
		this.mHisto = new History();
		this.gamePlayers = new ArrayList<>();
		initGameHandle();
	}

	void initGameHandle()throws QuitException{
		while (!askingSizeOfBoard()){}
		while(!askingNumberOfPlayers()){}
		createPlayers();
		mHisto.newManche();
	}

	private boolean askingSizeOfBoard() throws QuitException{
		String message = "What is the size of the Board ? (l*c)";
		String ans = mInterface.onInputMessage(message);

		String[] results = ans.split("\\*");
		if (results.length != 2){
			String error = "Two arguments are required, separate by *";
			mInterface.outputMessage(error);
			return false;
		}
		else{
			try {
				int numberOfLines = Integer.parseInt(results[0]);
				int numberOfColumns = Integer.parseInt(results[1]);
				this.game = new Game(new Board(numberOfLines,numberOfColumns),gamePlayers);
			}
			catch (NumberFormatException e){
				mInterface.outputMessage(e.toString());
				return false;
			}
		}
		return true;
	}

	private boolean askingNumberOfPlayers() throws QuitException{
		String message = "How many players will play ?";
		String ans = mInterface.onInputMessage(message);

		try {//convert ans to int 
			this.numberOfPlayer = Integer.parseInt(ans);
		}
		catch (NumberFormatException e){
			//deal with format error
			mInterface.outputMessage(e.toString());
			return false;
		}
		return true;
	}

	void createPlayers()throws QuitException{
		this.gamePlayers.clear();
		for (int i = 1; i <= numberOfPlayer;i++){
			Player p;
			while( (p = askingWhoIsPlayer(i,Symbol.values()[i-1]) ) == null){}
			gamePlayers.add(p);
		}
	}

	private Player askingWhoIsPlayer(int num, Symbol s) throws QuitException{
		String message = "Joueur "+num+"?";
		String ans = mInterface.onInputMessage(message);

		String[] results = ans.split(" ");
		if (results.length != 2){
			String error = "Erreur saisie Joueur "+num;
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
				return new IA(num,results[1],s.getSymbol(),game.getBoard().getNbColumns());
			}
			else{
				String error = "Erreur saisie Joueur "+num;
				mInterface.outputMessage(error);
				return null;
			}
		}
	}
	
	public boolean checkIfPlayerWin(){
		for (Player p : gamePlayers){
			if (p.getScore() >= POINTS_TO_WIN){
				//mInterface.outputMessage("Joueur "+ p.getNum() +" win.");
				mHisto.gameEnded();
				return true;
			}
		}
		return false;
	}

	public void nextRound() throws QuitException{
		Player p = game.getNextPlayerToMove();
		int wantToPlayInColumn;
		String ans = "0";
		if (!alreadyPrint)
			mInterface.outputMessage(game.getBoard().toString());
		
		/* get the column where the player wants to play */
		try {//Triing to convert String from user to int
			wantToPlayInColumn = p.play(mInterface,game.getBoard().toDoubles());
			//wantToPlayInColumn = ((IA) p).autoMove(game.getBoard().toDoubles());
		}
		catch (InvalidMoveException e){
			mInterface.outputMessage(e.getMessage());
			alreadyPrint = true;
			return;
		}
	
		try{//Triing to add a new Chip in the Board
			game.getBoard().addChip(wantToPlayInColumn,p.getSymbol(),p.getNum());
		}
		catch (InvalidMoveException e){
			mInterface.outputMessage(e.getMessage());
			p.invalidMove();
			alreadyPrint = true;
			return;
		}
		if (game.getBoard().getNbColumns() == 7 && game.getBoard().getNbLines() == 6){//Saving move for knn approach
				String s = game.getBoard().toLineString(p.getNum());
				mHisto.saveHumanMove(s, wantToPlayInColumn,p.getNum());
		}

		//Action to do when a player play
		final int playedColumn = wantToPlayInColumn;
		mHisto.playerMove(p.getNum(),playedColumn+1);
		game.playerHadPlayed();
		alreadyPrint = false;
		//mInterface.outputMessage(game.getBoard().toString());
		if (game.getBoard().isWin(playedColumn)){
			mInterface.outputMessage(game.getBoard().toString());
			mInterface.outputMessage("Joueur "+p.getNum()+" gagne");
			p.playerWin();
			mHisto.playerWin(p.getNum());
			mHisto.playersScore(gamePlayers);
			game.getBoard().cleanBoard();
			mHisto.newManche();
		}
		else if (game.getBoard().isFull()){
			mInterface.outputMessage(game.getBoard().toString());
			mInterface.outputMessage("Egalite");
			mHisto.playerWin(0);
			mHisto.playersScore(gamePlayers);
			game.getBoard().cleanBoard();
			mHisto.newManche();
		}

	}
}
