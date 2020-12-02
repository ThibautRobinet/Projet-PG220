package information;

import java.awt.EventQueue;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import board.Board;
import game.FormulaireGameHandle;
import player.Player;
import player.IA;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;

public class Formulaire extends JFrame {

    private Fenetre mFenetre;

    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel playersPanel;
    
    private int numberOfPlayer = 2;
    private int mancheToWin = 2;
    private int lines = 0;
    private int columns = 0;

    private List<Player> players;
    private final Color[] playersColor = {Color.RED,Color.YELLOW,Color.BLUE,Color.PINK};

    private boolean gameStarted = false;

    public Formulaire() {
        super();
        build();// On initialise notre fenêtre
    }

    private void build() {
        setBounds(100, 100, 400, 800);
        setTitle("Options de configuration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
        players = new ArrayList<>();
        for (int i = 1; i <= 4; i++){
            players.add(new Player(i,"",""));
        }
    }

    private JPanel buildContentPane() {
        // tests
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(title(), BorderLayout.NORTH);
        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
        mainPanel.add(createButton(),BorderLayout.SOUTH);
        return mainPanel;
    }

    private JPanel title(){
        JPanel centered = new JPanel();
        centered.setLayout(new FlowLayout());
        JLabel title = new JLabel("New Game :");
        centered.add(title);
        return centered;
    }
   
    private JPanel createCenterPanel(){
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,1, 10,10));

        //Settings pannel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1, 10,10));
        panel.add(numberOfPlayer());
        panel.add(numberOfMancheToWin());
        panel.add(numberOfLines());
        panel.add(numberOfColumns());
        centerPanel.add(panel);

        //players pannel
        playersPanel = new JPanel();
        centerPanel.add(playersPanel);
        numberOfPlayerChange(2);
        
        return centerPanel;
    }

    private JPanel numberOfPlayer(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2, 10,10));

        //title
        JLabel lbl = new JLabel("Nombre de joueurs :");
        panel.add(lbl);

        //selector
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(2);
        comboBox.addItem(3);
        comboBox.addItem(4);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                numberOfPlayerChange(comboBox.getSelectedIndex() + 2);
                numberOfPlayer = comboBox.getSelectedIndex() + 2;
            }
        });
        panel.add(comboBox);
        return panel;
    }

    private JPanel numberOfLines(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        JLabel nb_lignes = new JLabel("Lignes :");
        panel.add(nb_lignes);
        
        JPanel textPanel = new JPanel();
        JTextField textField =new JTextField();
        textPanel.setLayout(null);
        textPanel.add(textField);
        textField.setBounds(10,10, 60, 30);
        textField.setColumns(10);
        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                lines = textFieldToInt(textField.getText());
            }
            public void removeUpdate(DocumentEvent e) {
                lines = textFieldToInt(textField.getText());
            }
            public void insertUpdate(DocumentEvent e) {
               lines = textFieldToInt(textField.getText());
            }
          });
        panel.add(textPanel);
        return panel;
    }

    private JPanel numberOfColumns(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        JLabel nb_lignes = new JLabel("Colonnes :");
        panel.add(nb_lignes);
        
        JPanel textPanel = new JPanel();
        JTextField textField =new JTextField();
        textPanel.setLayout(null);
        textPanel.add(textField);
        textField.setBounds(10,10, 60, 30);
        textField.setColumns(10);
        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                columns = textFieldToInt(textField.getText());
            }
            public void removeUpdate(DocumentEvent e) {
                columns = textFieldToInt(textField.getText());
            }
            public void insertUpdate(DocumentEvent e) {
                columns = textFieldToInt(textField.getText());
            }
          });
        panel.add(textPanel);
        return panel;
    }
    
    private JPanel numberOfMancheToWin(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2, 10,10));

        //title
        JLabel lbl = new JLabel("Nombre de manche gagnante :");
        lbl.setBounds(65, 288, 67, 14);
        panel.add(lbl);

        //selector
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(2);
        comboBox.addItem(3);
        comboBox.addItem(4);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mancheToWin = comboBox.getSelectedIndex() + 2;
            }
        });
        comboBox.setBounds(180, 285, 91, 20);
        panel.add(comboBox);
        return panel;
    }

    private void numberOfPlayerChange(int num){
        playersPanel.setLayout(new GridLayout(num, 1, 10,10));
        playersPanel.removeAll();
        for( int i = 1; i <= num; i++){
            playersPanel.add(newUser(i, playersColor[i-1]));
        }
        playersPanel.invalidate();
        playersPanel.validate();
        playersPanel.repaint();
    }

    private JPanel newUser(int num, Color c){
        JPanel panel = new JPanel();
        panel.setLayout( new GridLayout(2,2, 30,30));
        panel.setBackground(c);

        //name
        JLabel Name = new JLabel("Joueur "+num+" :");
        panel.add(Name);

        JPanel textPanel = new JPanel();
        JTextField textField = new JTextField(10);
        textPanel.setLayout(null);
        textPanel.setBackground(c);
        textField.setBounds(10,0, 120, 30);
        textField.setColumns(10);
        textPanel.add(textField);
        panel.add(textPanel);
        
        //type
        JLabel type = new JLabel("Type :");
        panel.add(type);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("humain");
        comboBox.addItem("ia");
        panel.add(comboBox);

        //adding listener
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
                updatePlayer(num,textField.getText(),comboBox.getSelectedIndex());
            }
        });
        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updatePlayer(num,textField.getText(),comboBox.getSelectedIndex());
            }
            public void removeUpdate(DocumentEvent e) {
                updatePlayer(num,textField.getText(),comboBox.getSelectedIndex());
         
            }
            public void insertUpdate(DocumentEvent e) {
                updatePlayer(num,textField.getText(),comboBox.getSelectedIndex());
         
            }
          });
        
        
        return panel;
    }

    private JPanel createButton(){
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        JButton start = new JButton();
        start.setText("START");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                start();
            }
        });
        bottom.add(start);
        return bottom;
    }

    private int textFieldToInt(String text) {
        try {
            return (int)(Integer.parseInt(text));
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }
        return -1;
    }

    private void start(){
        System.out.println("game "+gameStarted);
        if (columns <= 0 || lines <= 0)
            return;
        System.out.println(lines + ":"+columns);
        System.out.println(numberOfPlayer + "=>" + mancheToWin);
        for (Player p : players){
            System.out.println(p.getNum() + " = " +p.getPlayerName() + " ia?"+p.isIA());
        }
       gameStarted = true;
        /*
         * FormulaireGameHandle mGameHandle; UserInterface mInterface; boolean running;
         * mInterface = new UserInterface(); mGameHandle = new
         * FormulaireGameHandle(mInterface,lines,columns,numberOfPlayer,mancheToWin,
         * allPlayers); createWindows(mGameHandle.getBoard()); running = true;
         * while(running){ //the game is running mGameHandle.nextRound();
         * mFenetre.setBoard(mGameHandle.getBoard()); //if a player win we stop the
         * program running = !mGameHandle.checkIfPlayerWin(); //mFenetre.u }
         */
    }

    public boolean gameIsStarted(){return gameStarted;}

    private void updatePlayer(int num, String name, int type) {
        switch (type) {
            case 1:
                players.set(num - 1, new IA(num, name, String.valueOf(num)));
                break;
            default:
                players.set(num - 1, new Player(num, name, String.valueOf(num)));
        }
    }

    public int getNumberOfPlayer(){
        return numberOfPlayer;
    }
    public int getPointsToWin(){
        return mancheToWin;
    }
    public int getLines(){
        return lines;
    }
    public int getColumns(){
        return columns;
    }
    public List<Player> getAllPlayers(){
        List<Player> allPlayers = new ArrayList<>();
        for (int i = 0; i < numberOfPlayer; i++){
            allPlayers.add(players.get(i));
        }
        return allPlayers;
    }
}

   


