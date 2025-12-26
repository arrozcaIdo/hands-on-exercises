import javax.swing.*;
import java.awt.*;

// BROCODE
public class JavaLabel {
    public static void main(String[] args){
        // JLabel = GUI display area for a string of text, image, or both

        ImageIcon image = new ImageIcon("C:/Users/Elyssa/IdeaProjects/hands-on-exercises/gui-javafx/roror.png");

        JLabel label = new JLabel();
        label.setText("Hello");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text, LEFT, CENTER, RIGHT
        label.setVerticalTextPosition(JLabel.TOP); // set text top, center, bottom of image
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.PLAIN,20));
        label.setIconTextGap(-1); // set gap btwn text n img
        label.setBackground(Color.black);
        label.setOpaque(true); // display background color



        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(label);
    }

}
