// email and name registration form n sobrang simple lng cuz dumudugo na utak q

package tries;

import javax.swing.*;
import java.awt.*;

public class Registration {
    
    JFrame frame = new JFrame("Registration Form (SIMPLE)");
    JPanel panel = new JPanel();
    
    Registration(){
        frame.setSize(400, 250);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);
        
        panel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        panel.add(emailField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);
        
        frame.add(panel);
        
        submitButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            
            if(!name.isEmpty() && !email.isEmpty()) {
                String message = "Name: " + name + "\nEmail: " + email;
                JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Registration();
        });
    }
}
