import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelTest extends JFrame {
    private JLabel label1, label2, label3;

    //setup GUI
    public LabelTest(){
        super("TITLE");

        //get content pane and set layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // JLabel constructor with a string argument
        label1 = new JLabel("Plain text.");
        label1. setToolTipText("hello?");
        container.add(label1);

        Icon bug = new ImageIcon("C://Users//Elyssa//IdeaProjects//hands-on-exercises//gui-javafx//roror.png");
        label2 = new JLabel("Text with Icon", bug, SwingConstants.LEFT);
        label2.setToolTipText("big ass globe");
        container.add(label2);

        // JLabel constructor no arguments
        label3 = new JLabel();
        label3.setText("Icon, text at bottom");
        label3.setIcon(bug);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("hellooooooooooo");
        container.add(label3);

        setSize(275, 500);
        setVisible(true);
    } // end constructor

    public static void main(String args[]){
        LabelTest application = new LabelTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}