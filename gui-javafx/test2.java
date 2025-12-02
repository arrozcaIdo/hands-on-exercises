import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class test2 extends JPanel {

    int pixelSize = 10;

    String[] walter = { // 32x32
           "11211111112122222211112122222211",
            "11311111111111222222222222221111",
            "11211111211111111112111111112111",
            "22111111122111111112211111222221",
            "13211111111222111111112122111211",
            "13311112222112221222211111123221",
            "32211124444322222223522235554532",
            "33112135444444444432344444444222",
            "33115224445455444452344433554522",
            "33112212533335454422345552222222",
            "33221211233233234411144352222222",
            "33311211122223234311154222222211",
            "33331221112222244211124522222222",
            "33331132222222543211223452222332",
            "33231235553333352221222233333222",
            "32321235522222532222222322222222",
            "32321225522225422221222242222222",
            "33331223522255542112222235522221",
            "33331122322232244522234522322221",
            "33332212532222354445544445532321",
            "33334512532254444444444445532321",
            "32444422322344444444444444442324",
            "34444442222344444444444444442324",
            "44444441322544355445354532543254",
            "44444451222542111122222222243254",
            "44444321122442223444444455443224",
            "44444222222544534444444455443224",
            "44445222222544444444444444443224",
            "44443222232344444444544444445354",
            "44445222335544444444444444445444",
            "44444532235454444444444444444444",
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int r = 0; r < walter.length; r++) {
            for (int c = 0; c < walter[r].length(); c++) {

                int value = walter[r].charAt(c) - '0';

                switch (value) {
                    case 1: g.setColor(Color.decode("#f9f2e5")); break;
                    case 2: g.setColor(Color.decode("#7ba310")); break;
                    case 3: g.setColor(Color.decode("#1c7348")); break;
                    case 4: g.setColor(Color.decode("#262e23")); break;
                    case 5: g.setColor(Color.decode("#69472c")); break;
                    default: g.setColor(Color.WHITE); break;
                }

                g.fillRect(c * pixelSize, r * pixelSize, pixelSize, pixelSize);

                g.setColor(new Color(220,220,220));
                g.drawRect(c * pixelSize, r * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "eughghghghhg");

        JFrame frame = new JFrame("burikakwhatthefuckisburikak");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new test2());
        frame.setSize(340, 350);
        frame.setVisible(true);
    }
}
