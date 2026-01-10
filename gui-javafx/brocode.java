package tries;

import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class brocode extends JFrame implements ActionListener{
	
	JRadioButton button1 = new JRadioButton("Pizza");
	JRadioButton button2 = new JRadioButton("Burger");
	JRadioButton button3 = new JRadioButton("Hotdog");
	
	ButtonGroup group = new ButtonGroup();
	
	
	brocode(){
		this.setLayout(new FlowLayout());
		this.setTitle("RADIO BUTTON");
		
		
		this.add(button1);
		this.add(button2);
		this.add(button3);

		group.add(button1);
		group.add(button2);
		group.add(button3);
		
		button1.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "You got Pizza!", "Congratulations!", 1);
		});
		
		button2.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "You got Burger!", "Congratulations!", 1);
		});
		
		button3.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "You got Hotdog!", "Congratulations!", 1);
		});
		
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new brocode());
		
	}

}
