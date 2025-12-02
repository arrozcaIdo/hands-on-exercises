// from chatgpt

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pixelEditor extends JPanel implements MouseListener {
    private final int rows = 16;
    private final int cols = 16;
    private final int cellSize = 30;

    private Color[][] grid = new Color[rows][cols];
    private Color currentColor = Color.BLACK;

    public pixelEditor() {
        setPreferredSize(new Dimension(cols * cellSize, rows * cellSize));
        addMouseListener(this);

        // Initialize grid with white pixels
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = Color.WHITE;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw colored cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                g.setColor(grid[r][c]);
                g.fillRect(c * cellSize, r * cellSize, cellSize, cellSize);

                g.setColor(Color.GRAY); // grid lines
                g.drawRect(c * cellSize, r * cellSize, cellSize, cellSize);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / cellSize;
        int row = e.getY() / cellSize;

        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col] = currentColor;
            repaint();
        }
    }

    // Unused mouse listener methods
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pixel Art Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pixelEditor art = new pixelEditor();
        frame.add(art);

        frame.pack();
        frame.setVisible(true);
    }
}
