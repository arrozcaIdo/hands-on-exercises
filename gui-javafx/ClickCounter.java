package tries;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class ClickCounter {
	int count = 0;
	JFrame frame = new JFrame("Click HERE!");
	JPanel displayPanel = new JPanel();
	JLabel displayLabel = new JLabel();
	Color customBG = new Color(60,80,100);
	
	ClickCounter(){
		frame.setSize(500,500);
		frame.getContentPane().setBackground(customBG);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JButton button = new JButton();
		button.setBorder(new LineBorder(Color.BLACK));
		button.setText("CLICK ME!");
		button.setBounds(150, 200, 200, 100);
		button.setFont(new Font("Arial", Font.BOLD, 22));
		frame.add(button);
		
		displayLabel.setText("CLICKS: 0");
		displayLabel.setBounds(150,100,500,50);
		displayLabel.setFont(new Font("Arial", Font.BOLD, 35));
		displayLabel.setForeground(Color.WHITE);
		frame.add(displayLabel);
		
		button.addActionListener(e -> {
			count++;
			displayLabel.setText("CLICKS: " + count);
			if(count % 10 == 0) {
				JOptionPane.showMessageDialog(frame, "WOAH", "You clicked TEN TIMES!! ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		ClickCounter Counter = new ClickCounter();
		
	}
}
