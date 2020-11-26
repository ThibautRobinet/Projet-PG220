package player;


import board.*;

//import player.IA;

public class Player{
	int numPlayer;
	int score;
	String name;
	String symbPlayer;
	//Type playerType;
	// Public Enum Type{
	// 	human,
	// 	ia
	// }

	public Player(int numPlayer, String name,String symbPlayer){
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

	private void setPlayerName(String name){
		this.name = name;
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

	protected void playerMove(int numeroColumn, Board mBoard){
		Chip mChip = new Chip(symbPlayer);
		mBoard.addChip(numeroColumn,mChip);
	}

}
/*
Class Player
//tout private
Var:
	int numPlayer;
	int score;
	String name;
	String symbPlayer;
	Type playerType;
	IA playerIA;
 Public Enum Type{
	human,
	ia
}
Constructeur:
	Player(int numPlayer,String symbPlayer);
Functions:
	int getNum();
	int getScore();
	void winGame();
	String getSymbol();
	void setPlayerName(String name);
	String getPlayerName();
	void playerMove(int numeroColumn, Board mBoard){
		Chip mChip = new Chip(symbPlayer);
		mBoard.addChip(numeroColumn,mChip)
	}
Erreurs:
	//erreur column pleine
*/
