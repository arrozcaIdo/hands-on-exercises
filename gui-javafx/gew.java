package tries;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Product {
    // fields
    public String name;
    public double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }
}

public class gew extends JFrame implements ActionListener {
    // instances of swing classes
    private JComboBox<String> bookComboBox; //<String> is needed
    private JRadioButton[] editions; // array. iterate thru edition 1-4 to set the same dimension
    private ButtonGroup editionGroup;
    private JCheckBox discountCheckBox;
    private JTextField priceField, quantityField, salesAmountField;
    private JButton computeButton, clearButton;

    // instances of Product class
    private Product javaProduct = new Product("JAVA PROGRAMMING", 500.00);
    private Product cSharpProduct = new Product("C# PROGRAMMING", 600.00);
    private Product pythonProduct = new Product("PYTHON PROGRAMMING", 550.00);
    private Product phpProduct = new Product("PHP PROGRAMMING", 650.00);

    private final double DISCOUNT_RATE = 0.10;

    public gew() { 
        setTitle("MJN Book Store");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // static constant (always uppercase) that belongs to the class, which is why JFrame is called first.
        setLayout(null);
        setResizable(false);

        initUI();

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initUI() {
        JLabel titleLabel = new JLabel("MJN Book Store", JLabel.CENTER); // title = JLabel
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // new Font instance with parameters. like static constants, BOLD is a setting that must be uppercase and calls the class name first
        titleLabel.setBounds(0, 10, 600, 30);
        add(titleLabel);

        add(new JLabel("PLEASE PICK A BOOK:")).setBounds(50, 60, 150, 25);
        String[] bookList = {"", "JAVA PROGRAMMING", "C# PROGRAMMING", "PYTHON PROGRAMMING", "PHP PROGRAMMING"}; // initialize array of String
        bookComboBox = new JComboBox<>(bookList); // use '<>' again. insert the array of String in the JComboBox object
        bookComboBox.setBounds(220, 60, 300, 25); 
        bookComboBox.addActionListener(this); // refer to 
        add(bookComboBox);

        add(new JLabel("EDITION")).setBounds(50, 100, 100, 25);
        editions = new JRadioButton[]{
            new JRadioButton("1st Edition"), new JRadioButton("2nd Edition"),
            new JRadioButton("3rd Edition"), new JRadioButton("4th Edition")
        };
        
        int[] xPos = {50, 50, 220, 220};
        int[] yPos = {130, 160, 130, 160};
        editionGroup = new ButtonGroup();

        for (int i = 0; i < editions.length; i++) {
            editions[i].setBounds(xPos[i], yPos[i], 120, 25);
            editions[i].addActionListener(this);
            editionGroup.add(editions[i]);
            add(editions[i]);
        }

        discountCheckBox = new JCheckBox("With Discount");
        discountCheckBox.setBounds(50, 200, 150, 25);
        discountCheckBox.setEnabled(false);
        discountCheckBox.addActionListener(this);
        add(discountCheckBox);

        add(new JLabel("PRICE:")).setBounds(380, 130, 60, 25);
        priceField = createTextField(450, 130, 120, false);

        add(new JLabel("QUANTITY:")).setBounds(50, 240, 100, 25);
        quantityField = createTextField(150, 240, 150, true);

        add(new JLabel("SALES AMOUNT:")).setBounds(50, 280, 120, 25);
        salesAmountField = createTextField(180, 280, 200, false);

        computeButton = new JButton("COMPUTE");
        computeButton.setBounds(150, 340, 140, 35);
        computeButton.addActionListener(this);
        add(computeButton);

        clearButton = new JButton("CLEAR");
        clearButton.setBounds(310, 340, 140, 35);
        clearButton.addActionListener(this);
        add(clearButton);
    }

    private JTextField createTextField(int x, int y, int w, boolean editable) {
        JTextField f = new JTextField();
        f.setBounds(x, y, w, 25);
        f.setEditable(editable);
        add(f);
        return f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == computeButton) {
            calculateTotal();
        } else if (e.getSource() == clearButton) {
            resetAll();
        } else {
            refreshPriceDisplay();
        }
    }

    private void refreshPriceDisplay() {
        String selection = (String) bookComboBox.getSelectedItem();
        Product selectedProduct = getSelectedProduct(selection);

        if (selectedProduct == null || editionGroup.getSelection() == null) {
            priceField.setText("");
            discountCheckBox.setEnabled(false);
            return;
        }

        boolean canDiscount = selection.equals("JAVA PROGRAMMING") || selection.equals("C# PROGRAMMING");
        discountCheckBox.setEnabled(canDiscount);
        if (!canDiscount) discountCheckBox.setSelected(false);

        // Accessing basePrice directly (No encapsulation)
        double unitPrice = selectedProduct.basePrice + getSurcharge();
        
        if (discountCheckBox.isSelected()) {
            unitPrice *= (1 - DISCOUNT_RATE);
        }

        priceField.setText(String.format("%.2f", unitPrice));
    }

    private Product getSelectedProduct(String title) {
        if (title.equals("JAVA PROGRAMMING")) return javaProduct;
        if (title.equals("C# PROGRAMMING")) return cSharpProduct;
        if (title.equals("PYTHON PROGRAMMING")) return pythonProduct;
        if (title.equals("PHP PROGRAMMING")) return phpProduct;
        return null;
    }

    private double getSurcharge() {
        if (editions[0].isSelected()) return 50.0;
        if (editions[1].isSelected()) return 100.0;
        if (editions[2].isSelected()) return 150.0;
        if (editions[3].isSelected()) return 200.0;
        return 0.0;
    }

    private void calculateTotal() {
        try {
            double price = Double.parseDouble(priceField.getText());
            int qty = Integer.parseInt(quantityField.getText());
            salesAmountField.setText(String.format("%.2f", price * qty));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Check your inputs!");
        }
    }

    private void resetAll() {
        bookComboBox.setSelectedIndex(0);
        editionGroup.clearSelection();
        discountCheckBox.setSelected(false);
        discountCheckBox.setEnabled(false);
        priceField.setText("");
        quantityField.setText("");
        salesAmountField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new gew());
    }
}
