import javax.swing.*;

public class isapa extends JFrame {
    private JLabel label1, label2;
    private JButton button1, button2;
    
   public isapa(){
    setSize(640, 400);
    setLocation(500, 250);
    setTitle("JFrame Components");
    setLayout(null);

    label1 = new JLabel("Label 1");
    label1.setBounds(10,10,100,20);
    add(label1);

    label2 = new JLabel("Label 2");
    label2.setBounds(150,40,100,20);
    add(label2);
    
    button1 = new JButton("Button 1");
    button1.setBounds(200,10,100,20);
    add(button1);

    button2 = new JButton("Button 2");
    button2.setBounds(300,40,100,20);
    add(button2);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}


    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new isapa());
        
    }

    
}
