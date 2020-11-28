import information.*;

import javax.security.auth.login.Configuration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.GameHandle;
import game.StandardGameHandle;
import information.UserInterface;
//import information.Fenetre;

public class Test {
	public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        new ImageJFrame();
        fenetre.setVisible(true);
        Fenetre options = new Fenetre();
        options.setTitle("Options de configuration");
        options.setSize(300, 700);

        JPanel container = new JPanel();
        String[] tab = {"humain", "ia"};
        JComboBox combo = new JComboBox(tab);
        JLabel label = new JLabel("Choix utilisateur");

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        combo.setPreferredSize(new Dimension(100, 30));

        JPanel top = new JPanel();
        top.add(label);
        top.add(combo);
        container.add(top, BorderLayout.NORTH);
        options.setContentPane(container);     
        options.setVisible(true);
        

        

     }


		/*History mHisto = new History();
		mHisto.newManche();
		mHisto.newPlayer(1, "humain", "John");
		mHisto.newPlayer(1, "ia", "Dark Vador");
		mHisto.playerMove(1, 1);
		mHisto.playerMove(2, 1);
		mHisto.playerMove(1, 2);
		mHisto.playerMove(2, 2);
		mHisto.playerMove(1, 3);
		mHisto.playerMove(2, 3);
		mHisto.playerMove(1, 4);
		mHisto.playerWin(0);
		mHisto.playersScore(1,0);
		mHisto.gameEnded();
		mHisto.playerMove(1, 3);*/
        
        


}