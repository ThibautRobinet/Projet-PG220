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

public class Test {

	static GameHandle mGameHandle;
	static UserInterface mInterface;
	static boolean running;

	public static void main(String[] args){
		mInterface = new FenetreInterface();
		mGameHandle = new FormulaireGameHandle(mInterface);
		running = true;
		while(running){
			//the game is running
			mGameHandle.nextRound();
			((FormulaireGameHandle) mGameHandle).updateFenetre();
			//if a player win we stop the program
			running = !mGameHandle.checkIfPlayerWin();
		}
	}
}