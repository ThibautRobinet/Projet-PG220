package information;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


final class Fenetre extends JFrame {

    private final String[] chipImgPath = {"./img/no_jeton.png","./img/jeton_rouge.png","./img/jeton_jaune.png","./img/jeton_bleu.png","./img/jeton_violet.png"};

    private JPanel mainPanel;
    private int lines,columns;
    private boolean waitInput = false;
    private String input;

    Fenetre() {
        this.lines = 1;
        this.columns = 1;
        this.setTitle("Fenetre de jeu");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(buildContentPane(lines, columns));
    }

    private JPanel buildContentPane(int l, int c) {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLUE);
        mainPanel.setLayout(new GridLayout(l+1,c,5,5));
        return mainPanel;
    }

    private void makeStringGrid(String s){
        mainPanel.removeAll();
        mainPanel.setBackground(Color.BLUE);

        //Get the size of grid from board to string
        String[] sLines = s.split("\n");
        this.lines = sLines.length - 1;
        String[] buttons = sLines[0].split("\\ ");
        this.columns = buttons.length;

        //Set up the grid with good dimensions
        mainPanel.setLayout(new GridLayout(lines+1,columns,5,5));

        //Adding top of column buttons
        for (int i = 1; i <= columns;i++){
            addButton(i);
        }

        //Placing chips in the grid
        for(int k = 1; k <= lines; k++){
            String[] chips = sLines[k].split("\\ ");
            for(int l = 0; l < columns; l++){
                int couleur;
                try{
                    couleur =  Integer.parseInt(chips[l]);
                }
                catch(NumberFormatException e){
                    couleur = 0;
                }
                addChip(couleur);
            }
        }

        //Update the screen
        updateMainPanel();
    }

    private void addChip(int num){
        ImageIcon image = new ImageIcon(chipImgPath[num]);
        Image img = image.getImage(); // transform it 
        Image newimg = img.getScaledInstance(600/(lines+1), 600/(lines+1),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        image = new ImageIcon(newimg); 
        mainPanel.add(new JLabel(image));
    }

    private void addButton(int num){
        JButton col = new JButton();
        col.setText(""+num);
        col.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                waitInput = false;
                input = col.getText();
            }
        });
        mainPanel.add(col);
    }

    private void updateMainPanel(){
        mainPanel.invalidate();
        mainPanel.validate();
        mainPanel.repaint();
    }

    void printBoard(String s){
        makeStringGrid(s);
    }

    void waitMove(){
        waitInput = true;
        input = "";
    }

    boolean isWaitInput(){
        return waitInput;
    }

    String getInput(){return input;}
}