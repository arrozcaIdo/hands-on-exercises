import javax.swing.*;
import java.awt.*;

public class test1 extends JPanel {

    int pixelSize = 40;

    int[][] heart = {
            {0,0,1,1,0,1,1,0,0},
            {0,1,2,2,1,2,2,1,0},
            {1,2,2,2,2,2,2,2,1},
            {1,2,2,2,2,2,2,2,1},
            {0,1,2,2,2,2,2,1,0},
            {0,0,1,2,2,2,1,0,0},
            {0,0,0,1,2,1,0,0,0},
            {0,0,0,0,1,0,0,0,0},
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int r = 0; r < heart.length; r++) {
            for (int c = 0; c < heart[0].length; c++) {

                switch (heart[r][c]) {
                    case 1: g.setColor(Color.BLACK); break;
                    case 2: g.setColor(Color.RED); break;
                    default: g.setColor(Color.WHITE); break;
                }

                g.fillRect(c * pixelSize, r * pixelSize, pixelSize, pixelSize);

                g.setColor(new Color(220,220,220));
                g.drawRect(c * pixelSize, r * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ror");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new test1());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
