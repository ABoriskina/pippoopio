package object;

import javax.swing.*;
import java.awt.*;

public class AntWorker extends Ant implements IAnt{
    String pathImage = "/home/user-kali/Downloads/AntWorker.png";

    @Override
    public JLabel beBorn(int x, int y){
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(pathImage));
        Dimension size = label.getPreferredSize();
        label.setBounds(x, y, size.width, size.height);
        return label;
    }

}
