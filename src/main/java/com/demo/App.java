package com.demo;

import javax.swing.*;
import java.awt.*;

public class App {

    public static String buildGreeting(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Ciao ospite";
        }
        return "Ciao " + name.trim();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = createGui();
            frame.setVisible(true);
        });
    }

    public static JFrame createGui() {
        JFrame frame = new JFrame("Java Swing CI Demo");
        frame.setName("mainFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JTextField nameField = new JTextField(20);
        nameField.setName("nameField");

        JButton button = new JButton("Saluta");
        button.setName("salutaButton");

        JLabel resultLabel = new JLabel("In attesa...");
        resultLabel.setName("resultLabel");

        button.addActionListener(e -> {
            String result = buildGreeting(nameField.getText());
            resultLabel.setText(result);
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Nome:"));
        panel.add(nameField);
        panel.add(button);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setLocationRelativeTo(null);

        return frame;
    }
}