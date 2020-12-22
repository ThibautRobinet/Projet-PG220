import information.History;
import game.GameHandle;
import game.StandardGameHandle;
import information.UserInterface;
import game.QuitException;

class Main {

	public static void main(String[] args){
		final GameHandle mGameHandle;
		final UserInterface mInterface;
		boolean running;
		mInterface = new UserInterface();
		running = true;
		try{
			mGameHandle = new StandardGameHandle(mInterface);
			while(running){
				//the game is running
				mGameHandle.nextRound();
				
				//if a player win we stop the program
				running = !mGameHandle.checkIfPlayerWin();
			}
		}
		catch (QuitException e){
			running = false;
		}
		
	}
}