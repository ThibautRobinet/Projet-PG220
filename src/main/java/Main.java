import game.GameHandle;
//import game.StandardGameHandle;
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