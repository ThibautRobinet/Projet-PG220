package information;

import java.util.concurrent.TimeUnit;

import board.Board;

public class FenetreInterface extends UserInterface {

    Fenetre mFenetre;

    public FenetreInterface(){
    }

    @Override
    public String onInputMessage(String userInput){//we wait that the user use button on the fenetre
        //Print what user have to do
        mFenetre.waitMove();
        while (mFenetre.isWaitInput()) {
			try {
                TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
			}
		}
        return mFenetre.getInput();
    }

    public void createFenetre(Board mBoard){
        mFenetre = new Fenetre(mBoard);
        mFenetre.setVisible(true);
    }

    public void updateFenetreBoard(Board b){
        mFenetre.setBoard(b);
    }
    @Override
    public boolean isFenetreInterface(){return true;}
}
