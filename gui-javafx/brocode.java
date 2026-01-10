package tries;

import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class brocode extends JFrame implements ActionListener{
	//JTextField textField = new JTextField();
	JButton button = new JButton("Submit");
	JCheckBox check = new JCheckBox("I agree");
	
	brocode(){
		this.setLayout(new FlowLayout());
		this.setTitle("pls agree");
		String[] responses = {"YES BYE IHY", "NO I AGREE!!"}; 
		
		this.add(check);
		check.setFocusable(false);
		check.setFont(new Font("Arial", Font.ITALIC, 16));
		button.addActionListener(e -> {
			if(check.isSelected()) {
			JOptionPane.showMessageDialog(null,"Success!", "Confidentiality Agreement", 1);
			} else {
				if(JOptionPane.showOptionDialog(null, "aw u dont agree w our terms?", "Confidentiality Agreement", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, responses, null ) == 0) {
					JOptionPane.showMessageDialog(null, "kbye", "ok", 0);
				} else {
					JOptionPane.showMessageDialog(null,"YAY Success!", "Confidentiality Agreement", 1);
				}
				
			}
			});
		
		this.add(button);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new brocode());
		
	}

}
