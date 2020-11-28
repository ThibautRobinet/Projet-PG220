import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//Utilisation API --> SWING

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JComboBox combo = new JComboBox();
    private JLabel label = new JLabel();

    public Fenetre() {
       this.setTitle("Fenetre de jeu");
       this.setSize(1000, 700);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



}