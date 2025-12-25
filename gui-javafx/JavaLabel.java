import javax.swing.*;
// BROCODE
public class JavaLabel {
    public static void main(String[] args){
        // JLabel = GUI display area for a string of text, image, or both

        JLabel label = new JLabel();
        label.setText("Hello");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(label);
    }

}
