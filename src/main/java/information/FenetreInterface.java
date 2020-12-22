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

    @Override
    public void outputMessage(String gameMessage){//we wait that the user use button on the fenetre
        //Print what user have to do
        super.outputMessage(gameMessage);
        //Get the number of line of message
        String[] lines = gameMessage.split("\n");
        if (lines.length > 1){//more than one line means this is the board
            updateBoard(gameMessage);
        }
    }

    public void createFenetre(){
        mFenetre = new Fenetre();
        mFenetre.setVisible(true);
    }

    public void closeFenetre(){
        mFenetre.closeWindow();
    }

    public void updateBoard(String s){
        mFenetre.printBoard(s);
    }

    @Override
    public boolean isFenetreInterface(){return true;}
}
