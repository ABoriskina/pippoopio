package object;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AntWarrior extends Ant implements IAnt {
    String pathImage = "/home/user-kali/Downloads/AntWarrior.png";
    public AntWarrior(){

    }

    @Override
    public JLabel beBorn(int x, int y){
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon(pathImage);
        label.setIcon(new ImageIcon(pathImage));
        Dimension size = label.getPreferredSize();
        label.setBounds(x, y, size.width, size.height);
        return label;
    }
}
