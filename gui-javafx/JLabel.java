import javax.swing.*;
import java.awt.*;


public class JLabel extends JFrame {
    private JLabel labelName1, labelName2, labelName3;

    public JLabel(){
        super("HelloWorld");


        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        labelName1 = new JLabel("ROR!");
        labelName1.setToolTipText("This is Label 1.");
        container.add(labelName1);
    }

    public static void main (String args[]){

    }

}
