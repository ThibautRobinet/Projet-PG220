package game;

import java.util.concurrent.TimeUnit;

import board.Board;
import information.FenetreInterface;
import information.Formulaire;
import information.UserInterface;

public class FormulaireGameHandle extends GameHandle {

	public FormulaireGameHandle(UserInterface mInterface) {
		super(mInterface);
	}

	@Override
	protected void initGameHandle() {
		Formulaire formulaire = new Formulaire();
		formulaire.setVisible(true);
		while (!formulaire.gameIsStarted()) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		formulaire.setVisible(false);
		super.numberOfPlayer = formulaire.getNumberOfPlayer();
		super.POINTS_TO_WIN = formulaire.getPointsToWin();
		super.gamePlayers = formulaire.getAllPlayers();
		int lines = formulaire.getLines();
		int columns = formulaire.getColumns();
		Board mBoard = new Board(lines,columns);
		super.game = new Game(numberOfPlayer, mBoard,super.gamePlayers);
		if (super.mInterface.isFenetreInterface())
			((FenetreInterface) super.mInterface).createFenetre(mBoard);
		}

	public Board getBoard(){
		return game.getBoard();
	}

	public void updateFenetre(){
		Board b = super.game.getBoard();
		if (super.mInterface.isFenetreInterface())
			((FenetreInterface) super.mInterface).updateFenetreBoard(b);
	}


}
