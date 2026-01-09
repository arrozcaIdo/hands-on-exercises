package tries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TempConverter {
    
    private JFrame frame;
    private JTextField celsiusField;
    private JTextField fahrenheitField;
    private JTextField kelvinField;
    private JComboBox<String> conversionMode;
    private JLabel formulaLabel;
    private JPanel colorPanel;
    private boolean isConverting = false;
    
    public TempConverter() {
        createGUI();
    }
    
    private void createGUI() {
        frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout(10, 10));
        
        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("🌡️ Temperature Converter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);
        
        // Main content panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Conversion Mode Selection
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        JLabel modeLabel = new JLabel("Conversion Mode:");
        modeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(modeLabel, gbc);
        
        gbc.gridx = 2; gbc.gridy = 0; gbc.gridwidth = 2;
        String[] modes = {"All Directions", "Celsius ↔ Fahrenheit", 
                         "Celsius ↔ Kelvin", "Fahrenheit ↔ Kelvin"};
        conversionMode = new JComboBox<>(modes);
        conversionMode.addActionListener(e -> updateConversionMode());
        mainPanel.add(conversionMode, gbc);
        
        // Temperature Input Fields
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        JLabel celsiusLabel = new JLabel("Celsius (°C):");
        celsiusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(celsiusLabel, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        celsiusField = new JTextField(15);
        celsiusField.setFont(new Font("Arial", Font.PLAIN, 14));
        celsiusField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { convertFromCelsius(); }
            public void removeUpdate(DocumentEvent e) { convertFromCelsius(); }
            public void insertUpdate(DocumentEvent e) { convertFromCelsius(); }
        });
        mainPanel.add(celsiusField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel fahrenheitLabel = new JLabel("Fahrenheit (°F):");
        fahrenheitLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(fahrenheitLabel, gbc);
        
        gbc.gridx = 1; gbc.gridy = 2;
        fahrenheitField = new JTextField(15);
        fahrenheitField.setFont(new Font("Arial", Font.PLAIN, 14));
        fahrenheitField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { convertFromFahrenheit(); }
            public void removeUpdate(DocumentEvent e) { convertFromFahrenheit(); }
            public void insertUpdate(DocumentEvent e) { convertFromFahrenheit(); }
        });
        mainPanel.add(fahrenheitField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel kelvinLabel = new JLabel("Kelvin (K):");
        kelvinLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(kelvinLabel, gbc);
        
        gbc.gridx = 1; gbc.gridy = 3;
        kelvinField = new JTextField(15);
        kelvinField.setFont(new Font("Arial", Font.PLAIN, 14));
        kelvinField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { convertFromKelvin(); }
            public void removeUpdate(DocumentEvent e) { convertFromKelvin(); }
            public void insertUpdate(DocumentEvent e) { convertFromKelvin(); }
        });
        mainPanel.add(kelvinField, gbc);
        
        // Formula Display
        gbc.gridx = 2; gbc.gridy = 1; gbc.gridheight = 3;
        formulaLabel = new JLabel("<html><div style='text-align: center;'>" +
                                 "<b>Formulas:</b><br>" +
                                 "°F = (°C × 9/5) + 32<br>" +
                                 "K = °C + 273.15<br>" +
                                 "°C = (°F - 32) × 5/9</div></html>");
        formulaLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));
        formulaLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        formulaLabel.setPreferredSize(new Dimension(200, 150));
        mainPanel.add(formulaLabel, gbc);
        
        frame.add(mainPanel, BorderLayout.CENTER);
        
        // Color Temperature Indicator
        colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(600, 50));
        colorPanel.setBackground(new Color(100, 149, 237)); // Default cornflower blue
        frame.add(colorPanel, BorderLayout.SOUTH);
        
        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        JButton clearButton = new JButton("Clear All");
        clearButton.setBackground(new Color(220, 53, 69));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.addActionListener(e -> clearAll());
        
        JButton swapButton = new JButton("Swap Focus");
        swapButton.setBackground(new Color(40, 167, 69));
        swapButton.setForeground(Color.WHITE);
        swapButton.setFont(new Font("Arial", Font.BOLD, 14));
        swapButton.addActionListener(e -> swapFocus());
        
        JButton presetButton = new JButton("Preset Temperatures");
        presetButton.setBackground(new Color(23, 162, 184));
        presetButton.setForeground(Color.WHITE);
        presetButton.setFont(new Font("Arial", Font.BOLD, 14));
        presetButton.addActionListener(e -> showPresets());
        
        buttonPanel.add(clearButton);
        buttonPanel.add(swapButton);
        buttonPanel.add(presetButton);
        
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        // Status Bar
        JLabel statusLabel = new JLabel(" Enter temperature in any field for real-time conversion ");
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        statusLabel.setBorder(BorderFactory.createEtchedBorder());
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(statusLabel, BorderLayout.PAGE_END);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void convertFromCelsius() {
        if (isConverting) return;
        
        String celsiusText = celsiusField.getText().trim();
        if (celsiusText.isEmpty()) {
            clearOtherFields("celsius");
            updateColor(0);
            return;
        }
        
        try {
            isConverting = true;
            double celsius = Double.parseDouble(celsiusText);
            
            // Convert based on selected mode
            String mode = (String) conversionMode.getSelectedItem();
            
            switch (mode) {
                case "All Directions":
                    double fahrenheit = (celsius * 9/5) + 32;
                    double kelvin = celsius + 273.15;
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                    kelvinField.setText(String.format("%.2f", kelvin));
                    break;
                    
                case "Celsius ↔ Fahrenheit":
                    fahrenheit = (celsius * 9/5) + 32;
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                    kelvinField.setText("");
                    break;
                    
                case "Celsius ↔ Kelvin":
                    kelvin = celsius + 273.15;
                    kelvinField.setText(String.format("%.2f", kelvin));
                    fahrenheitField.setText("");
                    break;
                    
                case "Fahrenheit ↔ Kelvin":
                    // No conversion from Celsius in this mode
                    fahrenheitField.setText("");
                    kelvinField.setText("");
                    break;
            }
            
            updateColor(celsius);
            updateFormula("celsius", celsius);
            
        } catch (NumberFormatException e) {
            // Invalid input, do nothing
        } finally {
            isConverting = false;
        }
    }
    
    private void convertFromFahrenheit() {
        if (isConverting) return;
        
        String fahrenheitText = fahrenheitField.getText().trim();
        if (fahrenheitText.isEmpty()) {
            clearOtherFields("fahrenheit");
            updateColor(0);
            return;
        }
        
        try {
            isConverting = true;
            double fahrenheit = Double.parseDouble(fahrenheitText);
            
            String mode = (String) conversionMode.getSelectedItem();
            
            switch (mode) {
                case "All Directions":
                    double celsius = (fahrenheit - 32) * 5/9;
                    double kelvin = celsius + 273.15;
                    celsiusField.setText(String.format("%.2f", celsius));
                    kelvinField.setText(String.format("%.2f", kelvin));
                    break;
                    
                case "Celsius ↔ Fahrenheit":
                    celsius = (fahrenheit - 32) * 5/9;
                    celsiusField.setText(String.format("%.2f", celsius));
                    kelvinField.setText("");
                    break;
                    
                case "Fahrenheit ↔ Kelvin":
                    celsius = (fahrenheit - 32) * 5/9;
                    kelvin = celsius + 273.15;
                    kelvinField.setText(String.format("%.2f", kelvin));
                    celsiusField.setText("");
                    break;
                    
                case "Celsius ↔ Kelvin":
                    // No conversion from Fahrenheit in this mode
                    celsiusField.setText("");
                    kelvinField.setText("");
                    break;
            }
            
            updateColor((fahrenheit - 32) * 5/9); // Convert to Celsius for color
            updateFormula("fahrenheit", fahrenheit);
            
        } catch (NumberFormatException e) {
            // Invalid input
        } finally {
            isConverting = false;
        }
    }
    
    private void convertFromKelvin() {
        if (isConverting) return;
        
        String kelvinText = kelvinField.getText().trim();
        if (kelvinText.isEmpty()) {
            clearOtherFields("kelvin");
            updateColor(0);
            return;
        }
        
        try {
            isConverting = true;
            double kelvin = Double.parseDouble(kelvinText);
            
            String mode = (String) conversionMode.getSelectedItem();
            
            switch (mode) {
                case "All Directions":
                    double celsius = kelvin - 273.15;
                    double fahrenheit = (celsius * 9/5) + 32;
                    celsiusField.setText(String.format("%.2f", celsius));
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                    break;
                    
                case "Celsius ↔ Kelvin":
                    celsius = kelvin - 273.15;
                    celsiusField.setText(String.format("%.2f", celsius));
                    fahrenheitField.setText("");
                    break;
                    
                case "Fahrenheit ↔ Kelvin":
                    celsius = kelvin - 273.15;
                    fahrenheit = (celsius * 9/5) + 32;
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                    celsiusField.setText("");
                    break;
                    
                case "Celsius ↔ Fahrenheit":
                    // No conversion from Kelvin in this mode
                    celsiusField.setText("");
                    fahrenheitField.setText("");
                    break;
            }
            
            updateColor(kelvin - 273.15); // Convert to Celsius for color
            updateFormula("kelvin", kelvin);
            
        } catch (NumberFormatException e) {
            // Invalid input
        } finally {
            isConverting = false;
        }
    }
    
    private void clearOtherFields(String source) {
        if (isConverting) return;
        
        isConverting = true;
        try {
            String mode = (String) conversionMode.getSelectedItem();
            
            switch (source) {
                case "celsius":
                    if (!mode.equals("Celsius ↔ Fahrenheit") && !mode.equals("Celsius ↔ Kelvin")) {
                        fahrenheitField.setText("");
                        kelvinField.setText("");
                    }
                    break;
                    
                case "fahrenheit":
                    if (!mode.equals("Celsius ↔ Fahrenheit") && !mode.equals("Fahrenheit ↔ Kelvin")) {
                        celsiusField.setText("");
                        kelvinField.setText("");
                    }
                    break;
                    
                case "kelvin":
                    if (!mode.equals("Celsius ↔ Kelvin") && !mode.equals("Fahrenheit ↔ Kelvin")) {
                        celsiusField.setText("");
                        fahrenheitField.setText("");
                    }
                    break;
            }
        } finally {
            isConverting = false;
        }
    }
    
    private void updateColor(double celsius) {
        // Color scale from blue (cold) to red (hot)
        int red, green, blue;
        
        if (celsius < -50) {
            red = 0; green = 0; blue = 255; // Very cold - blue
        } else if (celsius < 0) {
            red = 0; green = 150; blue = 255; // Cold - light blue
        } else if (celsius < 20) {
            red = 0; green = 200; blue = 100; // Cool - green
        } else if (celsius < 35) {
            red = 255; green = 200; blue = 0; // Warm - yellow/orange
        } else if (celsius < 60) {
            red = 255; green = 100; blue = 0; // Hot - orange
        } else {
            red = 255; green = 0; blue = 0; // Very hot - red
        }
        
        colorPanel.setBackground(new Color(red, green, blue));
        
        // Update label based on temperature
        String tempDescription;
        if (celsius < -20) tempDescription = "Extreme Cold";
        else if (celsius < 0) tempDescription = "Freezing";
        else if (celsius < 10) tempDescription = "Cold";
        else if (celsius < 20) tempDescription = "Cool";
        else if (celsius < 30) tempDescription = "Room Temperature";
        else if (celsius < 40) tempDescription = "Warm";
        else if (celsius < 60) tempDescription = "Hot";
        else tempDescription = "Extreme Heat";
        
        JLabel tempLabel = new JLabel(String.format("Current: %.1f°C - %s", celsius, tempDescription));
        tempLabel.setFont(new Font("Arial", Font.BOLD, 14));
        tempLabel.setForeground(Color.WHITE);
        tempLabel.setHorizontalAlignment(JLabel.CENTER);
        colorPanel.removeAll();
        colorPanel.add(tempLabel);
        colorPanel.revalidate();
        colorPanel.repaint();
    }
    
    private void updateFormula(String source, double value) {
        String formula = "";
        
        switch (source) {
            case "celsius":
                formula = String.format("<html><div style='text-align: center;'><b>Conversion from °C:</b><br>" +
                                      "°F = (%.2f × 9/5) + 32 = %.2f°F<br>" +
                                      "K = %.2f + 273.15 = %.2fK</div></html>",
                                      value, (value * 9/5) + 32, value, value + 273.15);
                break;
                
            case "fahrenheit":
                formula = String.format("<html><div style='text-align: center;'><b>Conversion from °F:</b><br>" +
                                      "°C = (%.2f - 32) × 5/9 = %.2f°C<br>" +
                                      "K = (%.2f - 32) × 5/9 + 273.15 = %.2fK</div></html>",
                                      value, (value - 32) * 5/9, value, (value - 32) * 5/9 + 273.15);
                break;
                
            case "kelvin":
                formula = String.format("<html><div style='text-align: center;'><b>Conversion from K:</b><br>" +
                                      "°C = %.2f - 273.15 = %.2f°C<br>" +
                                      "°F = (%.2f - 273.15) × 9/5 + 32 = %.2f°F</div></html>",
                                      value, value - 273.15, value, (value - 273.15) * 9/5 + 32);
                break;
        }
        
        formulaLabel.setText(formula);
    }
    
    private void updateConversionMode() {
        String mode = (String) conversionMode.getSelectedItem();
        
        // Clear all fields when mode changes
        celsiusField.setText("");
        fahrenheitField.setText("");
        kelvinField.setText("");
        updateColor(0);
        
        // Update formula label
        String formula = "";
        switch (mode) {
            case "All Directions":
                formula = "<html><div style='text-align: center;'><b>All Conversions Active</b><br>" +
                         "Enter temperature in any field<br>" +
                         "to see conversions in all units</div></html>";
                break;
                
            case "Celsius ↔ Fahrenheit":
                formula = "<html><div style='text-align: center;'><b>Celsius ↔ Fahrenheit</b><br>" +
                         "°F = (°C × 9/5) + 32<br>" +
                         "°C = (°F - 32) × 5/9</div></html>";
                break;
                
            case "Celsius ↔ Kelvin":
                formula = "<html><div style='text-align: center;'><b>Celsius ↔ Kelvin</b><br>" +
                         "K = °C + 273.15<br>" +
                         "°C = K - 273.15</div></html>";
                break;
                
            case "Fahrenheit ↔ Kelvin":
                formula = "<html><div style='text-align: center;'><b>Fahrenheit ↔ Kelvin</b><br>" +
                         "K = (°F - 32) × 5/9 + 273.15<br>" +
                         "°F = (K - 273.15) × 9/5 + 32</div></html>";
                break;
        }
        
        formulaLabel.setText(formula);
    }
    
    private void clearAll() {
        celsiusField.setText("");
        fahrenheitField.setText("");
        kelvinField.setText("");
        updateColor(0);
        formulaLabel.setText("<html><div style='text-align: center;'><b>Formulas:</b><br>" +
                           "°F = (°C × 9/5) + 32<br>" +
                           "K = °C + 273.15<br>" +
                           "°C = (°F - 32) × 5/9</div></html>");
        celsiusField.requestFocus();
    }
    
    private void swapFocus() {
        if (celsiusField.hasFocus()) {
            fahrenheitField.requestFocus();
        } else if (fahrenheitField.hasFocus()) {
            kelvinField.requestFocus();
        } else if (kelvinField.hasFocus()) {
            celsiusField.requestFocus();
        } else {
            celsiusField.requestFocus();
        }
    }
    
    private void showPresets() {
        String[] presets = {
            "Absolute Zero: -273.15°C",
            "Freezing Point: 0°C",
            "Room Temperature: 20°C",
            "Body Temperature: 37°C",
            "Boiling Water: 100°C",
            "Sun Surface: 5500°C"
        };
        
        String selected = (String) JOptionPane.showInputDialog(
            frame,
            "Select a preset temperature:",
            "Preset Temperatures",
            JOptionPane.PLAIN_MESSAGE,
            null,
            presets,
            presets[0]
        );
        
        if (selected != null) {
            double celsius = 0;
            switch (selected) {
                case "Absolute Zero: -273.15°C": celsius = -273.15; break;
                case "Freezing Point: 0°C": celsius = 0; break;
                case "Room Temperature: 20°C": celsius = 20; break;
                case "Body Temperature: 37°C": celsius = 37; break;
                case "Boiling Water: 100°C": celsius = 100; break;
                case "Sun Surface: 5500°C": celsius = 5500; break;
            }
            
            celsiusField.setText(String.format("%.2f", celsius));
            convertFromCelsius();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TempConverter();
        });
    }
}
