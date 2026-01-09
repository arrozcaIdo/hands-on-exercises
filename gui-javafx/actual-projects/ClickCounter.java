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
		button.setBounds(40, 200, 200, 100);
		button.setFont(new Font("Arial", Font.BOLD, 22));
		frame.add(button);
		
		JButton btnReset = new JButton();
		btnReset.setBorder(new LineBorder(Color.BLACK));
		btnReset.setText("reset :(");
		btnReset.setBounds(250, 200, 200, 100);
		btnReset.setFont(new Font("Arial", Font.BOLD, 22));
		btnReset.setForeground(new Color(20, 80, 50));
		frame.add(btnReset);
		
		displayLabel.setText("CLICKS: 0");
		displayLabel.setBounds(150,100,500,50);
		displayLabel.setFont(new Font("Arial", Font.BOLD, 35));
		displayLabel.setForeground(Color.WHITE);
		frame.add(displayLabel);
		
		button.addActionListener(e -> {
			count++;
			displayLabel.setText("CLICKS: " + count);
			if(count % 10 == 0) {
				JOptionPane.showMessageDialog(frame, "You clicked " + count + " TIMES!! ", "WTHELLY", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnReset.addActionListener(e -> {
			count = 0;
			displayLabel.setText("CLICKS: " + count);
		});
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		ClickCounter Counter = new ClickCounter();
		
	}
}
