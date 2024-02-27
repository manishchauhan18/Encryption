import javax.swing.*;
import java.awt.event.*;

public class ShiftCipherGUI {
    private JFrame frame;
    private JTextField plaintextField;
    private JTextField keyField;
    private JTextField encryptedField;
    private JTextField decryptKeyField;
    private JTextField decryptedField;

    public ShiftCipherGUI() {
        frame = new JFrame("Shift Cipher");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel plaintextLabel = new JLabel("Plaintext:");
        plaintextLabel.setBounds(20, 20, 80, 20);
        frame.add(plaintextLabel);

        plaintextField = new JTextField();
        plaintextField.setBounds(100, 20, 200, 20);
        frame.add(plaintextField);

        JLabel keyLabel = new JLabel("Encryption Key:");
        keyLabel.setBounds(20, 50, 100, 20);
        frame.add(keyLabel);

        keyField = new JTextField();
        keyField.setBounds(130, 50, 50, 20);
        frame.add(keyField);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(250, 50, 100, 20);
        frame.add(encryptButton);

        JLabel encryptedLabel = new JLabel("Encrypted Text:");
        encryptedLabel.setBounds(20, 80, 100, 20);
        frame.add(encryptedLabel);

        encryptedField = new JTextField();
        encryptedField.setBounds(130, 80, 220, 20);
        encryptedField.setEditable(false);
        frame.add(encryptedField);

        JLabel decryptKeyLabel = new JLabel("Decryption Key:");
        decryptKeyLabel.setBounds(20, 110, 100, 20);
        frame.add(decryptKeyLabel);

        decryptKeyField = new JTextField();
        decryptKeyField.setBounds(130, 110, 50, 20);
        frame.add(decryptKeyField);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(250, 110, 100, 20);
        frame.add(decryptButton);

        JLabel decryptedLabel = new JLabel("Decrypted Text:");
        decryptedLabel.setBounds(20, 140, 100, 20);
        frame.add(decryptedLabel);

        decryptedField = new JTextField();
        decryptedField.setBounds(130, 140, 220, 20);
        decryptedField.setEditable(false);
        frame.add(decryptedField);

        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String plaintext = plaintextField.getText().toUpperCase();
                int key = Integer.parseInt(keyField.getText());
                String encryptedText = ShiftCipher.encrypt(plaintext, key);
                encryptedField.setText(encryptedText);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String encryptedText = encryptedField.getText();
                int key = Integer.parseInt(decryptKeyField.getText());
                String decryptedText = ShiftCipher.decrypt(encryptedText, key);
                decryptedField.setText(decryptedText);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ShiftCipherGUI();
    }
}
