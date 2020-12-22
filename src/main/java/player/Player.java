package player;

import information.UserInterface;
import game.QuitException;
import game.board.InvalidMoveException;

public class Player{
	int numPlayer;
	int score;
	String name;
	String symbPlayer;

	public Player(int numPlayer, String name, String symbPlayer){
		this.numPlayer = numPlayer;
		this.score = 0;
		this.name = name;
		this.symbPlayer = symbPlayer;
	}

	public int getNum(){
		return this.numPlayer;
	}

	public int getScore(){
		return score;
	}

	public String getSymbol(){
		return this.symbPlayer;
	}

	public String getPlayerName(){
		return this.name;
	}

	public boolean winGame(){
		if (this.getScore()>=2){
			//System.out.println(state1);
			return true;
		}
		else{
			return false;
		}
	}

	public void playerWin(){
		this.score ++;
	}

	public int play(UserInterface mInterface,double[] board) throws InvalidMoveException,QuitException {
		int columnToPlay;
		String message = "";
		String ans = mInterface.onInputMessage(message);
		try{
		columnToPlay = Integer.parseInt(ans);
		}
		catch (NumberFormatException e){
			throw new InvalidMoveException("Erreur saisie colonne "+ans);
		}
		columnToPlay --;
		return  columnToPlay;
	}
	public void invalidMove(){};
}
