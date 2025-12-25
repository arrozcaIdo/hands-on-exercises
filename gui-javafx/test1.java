import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;

// thru 2d array

public class test1 extends JPanel {

    int pixelSize = 15;

    int[][] heart = { //20x20dim
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,0,0,0,0},
    {0,0,0,0,0,1,2,2,2,1,2,2,2,1,0,0,0,0,0,0},
    {0,0,0,0,1,2,0,2,2,2,2,2,2,2,1,0,0,0,0,0},
    {0,0,1,1,1,1,1,1,2,2,2,2,1,1,1,1,1,1,0,0},
    {0,1,0,0,1,3,1,1,2,2,2,2,1,1,1,0,0,0,1,0},
    {0,0,0,1,1,1,1,2,2,2,2,2,3,1,1,1,1,0,0,0},
    {0,0,1,0,1,1,0,1,2,2,2,3,1,0,1,1,0,1,0,0},
    {0,0,0,0,0,0,0,1,3,2,3,1,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,1,3,1,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0},
    {0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0},
    {0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0},
    {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}

};


@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int r = 0; r < heart.length; r++) {
            for (int c = 0; c < heart[0].length; c++) {

                switch (heart[r][c]) {
                    case 1: g.setColor(Color.decode("#000000")); break;
                    case 2: g.setColor(Color.decode("#ff0000")); break;
                    case 3: g.setColor(Color.decode("#bd0202")); break;

                    case 4: g.setColor(Color.decode("#cf0b0d")); break;
                    case 5: g.setColor(Color.decode("#af0d0a")); break;
                    case 6: g.setColor(Color.decode("#6b0d1b")); break;

                    case 7: g.setColor(Color.decode("#316910")); break;
                    case 8: g.setColor(Color.decode("#408a19")); break;
                    case 9: g.setColor(Color.decode("#8d2540")); break;
                    case 10: g.setColor(Color.decode("#8e0b11")); break;
                    default: g.setColor(Color.decode("#ffffff")); break;
                }

                g.fillRect(c * pixelSize, r * pixelSize, pixelSize, pixelSize);

                g.setColor(new Color(220,220,220));
                g.drawRect(c * pixelSize, r * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "pokiqnakulayrosas");

        JFrame frame = new JFrame("ror");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new test1());
        frame.setSize(300, 340);
        frame.setVisible(true);
    }
}
