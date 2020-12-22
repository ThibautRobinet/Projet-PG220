import information.*;

import javax.security.auth.login.Configuration;


import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import game.GameHandle;
import game.StandardGameHandle;
import game.FormulaireGameHandle;
import information.UserInterface;
import game.QuitException;


public class Test {

	public static void main(String[] args){
		final GameHandle mGameHandle;
		final UserInterface mInterface;
		boolean running;
		mInterface = new FenetreInterface();
		running = true;
		try{
			mGameHandle = new FormulaireGameHandle(mInterface);
			while(running){
				//the game is running
				mGameHandle.nextRound();
				((FormulaireGameHandle) mGameHandle).updateBoard();
				//if a player win we stop the program
				running = !mGameHandle.checkIfPlayerWin();
			}
		}
		catch (QuitException e){
			running = false;
		}
	}
}