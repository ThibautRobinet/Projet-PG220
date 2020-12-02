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

import board.Board;
import board.Chip;


public class Fenetre extends JFrame {

    private JPanel mainPanel;

    private final String[] chipImgPath = {"./img/no_jeton.png","./img/jeton_jaune.png","./img/jeton_rouge.png","./img/jeton_bleu.png","./img/jeton_violet.png"};

    private int lines,columns;
    private Board mBoard;

    private boolean waitInput = false;
    private String input;

    public Fenetre(Board b) {
        lines = b.getNbLines();
        columns = b.getNbColumns();
        mBoard = b;
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
        //mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        makeGrid();
        return mainPanel;
    }
    
    private void makeGrid(){
        mainPanel.removeAll();
        mainPanel.setBackground(Color.BLUE);
        mainPanel.setLayout(new GridLayout(lines+1,columns,5,5));
        for(int k = 1; k <= lines+1; k++){
            for(int l = 1; l <= columns; l++){
                if (k == 1){
                    addButton(l);
                }
                else{
                    Chip mChip = this.mBoard.getChip(lines+1-k,l-1);
                    if (mChip == null)
                        addChip(0);
                    else{
                        int couleur =  Integer.parseInt(mChip.getSymbol());
                        addChip(couleur);
                    }
                }
            }
        }
    }

    public void addChip(int num){
        ImageIcon image = new ImageIcon(chipImgPath[num]);
        Image img = image.getImage(); // transform it 
        Image newimg = img.getScaledInstance(600/(lines+1), 600/(lines+1),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        image = new ImageIcon(newimg); 
        mainPanel.add(new JLabel(image));
        updateMainPanel();
    }

    public void addButton(int num){
        JButton col = new JButton();
        col.setText(""+num);
        col.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                waitInput = false;
                input = col.getText();
            }
        });
        mainPanel.add(col);
        updateMainPanel();
    }

    public void updateMainPanel(){
        mainPanel.invalidate();
        mainPanel.validate();
        mainPanel.repaint();
    }

    public void setBoard(Board b){
        this.mBoard = b;
        makeGrid();
    }

    public void waitMove(){
        waitInput = true;
        input = "";
    }

    public boolean isWaitInput(){
        return waitInput;
    }

    public String getInput(){return input;}
}