package tries;

import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class brocode extends JFrame implements ActionListener{
	JTextField textField = new JTextField();
	JButton submit = new JButton("Submit");
	
	brocode(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		textField.setPreferredSize(new Dimension(250, 40));
		textField.setFont(new Font("Arial", Font.BOLD, 35));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		submit.addActionListener(this);
		

		this.add(textField);
		this.add(submit);
		this.pack();
		this.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			JOptionPane.showMessageDialog(null, "Hellooo " + textField.getText(), "NEW USER", 1);
			textField.setEditable(false);
			submit.setEnabled(false);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new brocode());
		
	}
}
