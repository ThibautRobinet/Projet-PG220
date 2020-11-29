import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;


public class Formulaire{
    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;


    public Formulaire() {

        frame = new JFrame();
        frame.setBounds(100, 100, 500, 900);
        frame.setTitle("Options de configuration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        textField = new JTextField();
        textField.setBounds(128, 28, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
         

        JLabel Name1 = new JLabel("Name 1");
        Name1.setBounds(65, 31, 46, 14);
        frame.getContentPane().add(Name1);

        //Name1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel Name2 = new JLabel("Name 2");
        Name2.setBounds(65, 31, 46, 14);
        frame.getContentPane().add(Name2);

        //Name2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel type = new JLabel("Type 1");
        type.setBounds(65, 228, 46, 14);
        frame.getContentPane().add(type);
        
        JLabel Humain = new JLabel("Humain");
        Humain.setBounds(128, 228, 46, 14);
        frame.getContentPane().add(Humain);
        
        JLabel ia_type = new JLabel("ia");
        ia_type.setBounds(292, 228, 46, 14);
        frame.getContentPane().add(ia_type);

        JLabel type2 = new JLabel("Type 2");
        type2.setBounds(65, 228, 46, 14);
        frame.getContentPane().add(type2);
         
        JLabel Humain2 = new JLabel("Humain");
        Humain2.setBounds(128, 228, 46, 14);
        frame.getContentPane().add(Humain2);
         
        JLabel ia_type2 = new JLabel("ia");
        ia_type2.setBounds(292, 228, 46, 14);
        frame.getContentPane().add(ia_type2);        



        JLabel nb_colonnes = new JLabel("Colonnes");
        nb_colonnes.setBounds(65, 68, 46, 14);
        frame.getContentPane().add(nb_colonnes);
     
    // textField_1 = new JTextField();
    // textField_1.setBounds(128, 65, 86, 20);
    // frame.getContentPane().add(textField_1);
    // textField_1.setColumns(10);
     
    JLabel nb_lignes = new JLabel("Lignes");
    nb_lignes.setBounds(65, 115, 46, 14);
    frame.getContentPane().add(nb_lignes);
     
    textField_2 = new JTextField();
    textField_2.setBounds(128, 112, 247, 17);
    frame.getContentPane().add(textField_2);
    textField_2.setColumns(10);
     
     

     
    JButton btnClear = new JButton("Clear");
     
    btnClear.setBounds(312, 387, 89, 23);
    frame.getContentPane().add(btnClear);
     
     
    JRadioButton radioButton = new JRadioButton("");
    radioButton.setBounds(337, 224, 109, 23);
    frame.getContentPane().add(radioButton);
     
    JRadioButton radioButton_1 = new JRadioButton("");
    radioButton_1.setBounds(162, 224, 109, 23);
    frame.getContentPane().add(radioButton_1);
     
    JLabel lblOccupation = new JLabel("Nombre de manches gagnantes pour une partie");
    lblOccupation.setBounds(65, 288, 67, 14);
    frame.getContentPane().add(lblOccupation);
     
    JComboBox comboBox = new JComboBox();
    comboBox.addItem("2");
    comboBox.addItem("3");
    comboBox.addItem("4");
    comboBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        }
    });
    comboBox.setBounds(180, 285, 91, 20);
    frame.getContentPane().add(comboBox);
     
     
    JButton btnSubmit = new JButton("submit");
     
    btnSubmit.setBackground(Color.BLUE);
    btnSubmit.setForeground(Color.GREEN);
    btnSubmit.setBounds(65, 387, 89, 23);
    frame.getContentPane().add(btnSubmit);
 
    }

}

   


