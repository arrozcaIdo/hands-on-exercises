import javax.swing.JOptionPane;
import java.util.Locale;

public class practice {

    public static void main(String[] args){

        String name = JOptionPane.showInputDialog("Enter name: ");
        JOptionPane.showMessageDialog(null, "Hello " + name.toUpperCase() + "!");

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age: ")); //parseint convert to int
        JOptionPane.showMessageDialog(null, "You are " + age + " years old!");

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter height: "));
        JOptionPane.showMessageDialog(null, "You are " + height + " cm tall!");

    }
}
