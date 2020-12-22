package information;

import java.util.concurrent.TimeUnit;

public final class FenetreInterface extends UserInterface {

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

    public void createFenetre(){
        mFenetre = new Fenetre();
        mFenetre.setVisible(true);
    }

    public void updateBoard(String s){
        mFenetre.printBoard(s);
    }

    @Override
    public boolean isFenetreInterface(){return true;}
}
