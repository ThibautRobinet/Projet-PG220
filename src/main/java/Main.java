import information.History;
import game.GameHandle;
import game.StandardGameHandle;
import information.UserInterface;

class Main {

	static GameHandle mGameHandle;
	static UserInterface mInterface;
	static boolean running;

	public static void main(String[] args){
		mInterface = new UserInterface();
		mGameHandle = new GameHandle(mInterface);
		running = true;
		while(running){
			//the game is running
			mGameHandle.nextRound();
			//if a player win we stop the program
			running = !mGameHandle.checkIfPlayerWin();
		}

		/*History mHisto = new History();
		mHisto.newManche();
		mHisto.newPlayer(1, "humain", "John");
		mHisto.newPlayer(1, "ia", "Dark Vador");
		mHisto.playerMove(1, 1);
		mHisto.playerMove(2, 1);
		mHisto.playerMove(1, 2);
		mHisto.playerMove(2, 2);
		mHisto.playerMove(1, 3);
		mHisto.playerMove(2, 3);
		mHisto.playerMove(1, 4);
		mHisto.playerWin(0);
		mHisto.playersScore(1,0);
		mHisto.gameEnded();
		mHisto.playerMove(1, 3);*/
		
	}
}
/*
Class Main
//ceci est notre “main”,
Var:
	GameHandle game;
	UserInterface mInterface;
	boolean running;
Constructeur:
	main(){
		this.game = new StandardGameHandle();
		while(running)
	}
Functions:
*/