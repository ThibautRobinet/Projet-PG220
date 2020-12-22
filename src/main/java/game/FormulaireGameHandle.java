package game;

import java.util.concurrent.TimeUnit;

import game.board.*;
import information.FenetreInterface;
import information.Formulaire;
import information.UserInterface;

public class FormulaireGameHandle extends GameHandle {

	public FormulaireGameHandle(UserInterface mInterface) throws QuitException{
		super(mInterface);
	}

	@Override
	protected void initGameHandle() throws QuitException {
		Formulaire formulaire = new Formulaire();
		formulaire.setVisible(true);
		while (!formulaire.gameIsStarted()) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		formulaire.setVisible(false);
		this.numberOfPlayer = formulaire.getNumberOfPlayer();
		this.POINTS_TO_WIN = formulaire.getPointsToWin();
		this.gamePlayers = formulaire.getAllPlayers();
		int lines = formulaire.getLines();
		int columns = formulaire.getColumns();
		Board mBoard = new Board(lines,columns);
		this.game = new Game(mBoard,super.gamePlayers);
		if (this.mInterface.isFenetreInterface()){
			((FenetreInterface) this.mInterface).createFenetre();
			updateBoard();
		}
	}

	public void updateBoard(){
		Board b = super.game.getBoard();
		if (super.mInterface.isFenetreInterface())
			((FenetreInterface) super.mInterface).updateBoard(b.toString());
	}

}
