
import information.History;
import game.FormulaireGameHandle;
import information.FenetreInterface;
import game.QuitException;

public class MainFormulaire {

	public static void main(String[] args){
		final FormulaireGameHandle mGameHandle;
		final FenetreInterface mInterface;
		boolean running;
		mInterface = new FenetreInterface();
		running = true;
		try{
			mGameHandle = new FormulaireGameHandle(mInterface);
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
        mInterface.closeFenetre();
    }
}