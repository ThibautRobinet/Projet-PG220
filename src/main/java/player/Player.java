package player;


import board.Board;
//import player.IA;

public class Player{
	int numPlayer;
	int score;
	String name;
	String symbPlayer;
	Type playerType;
	// Public Enum Type{
	// 	human,
	// 	ia
	// }

	public Player(int numPlayer, int score, String name,String symbPlayer){
		this.numPlayer = numPlayer;
		this.score = score;
		this.name = name;
		this.symbPlayer = symbPlayer;
	}

	private int getNum(){
		return this.numPlayer;
	}

	private int getscore(){
		return this.score;
	}

	private String getSymbol(){
		return this.symbPlayer;
	}

	private String getPlayerName(){
		return this.name;
	}

	private void setPlayerName(String name){
		this.name = name;
	}

	private boolean winGame(){
		if (getScore()>=2){
			//System.out.println(state1);
			return true;
		}
		else{
			return false;
		}
		
	}

	private playerMove(int numeroColumn, Board mBoard){
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
