import javax.swing.*;



public class ImageJFrame
{
  ImageJFrame() 
  {
    JFrame frame = new JFrame();
    ImageIcon image = new ImageIcon("../jeton_jaune.png");
    frame.add(new JLabel(image));
    frame.pack();
    frame.setVisible(true);
  }


} 
