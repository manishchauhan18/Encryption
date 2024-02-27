import java.util.Scanner;

public class ShiftCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the plaintext:");
        String plaintext = scanner.nextLine().toUpperCase(); // Convert to uppercase for simplicity

        System.out.println("Enter the key (a number from 1 to 25):");
        int key = scanner.nextInt();

        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted text: " + encryptedText);

        System.out.println("Enter the key to decrypt:");
        int decryptKey = scanner.nextInt();

        String decryptedText = decrypt(encryptedText, decryptKey);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char encryptedChar = (char) (((ch - 'A' + key) % 26) + 'A');
                result.append(encryptedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char decryptedChar = (char) (((ch - 'A' - key + 26) % 26) + 'A');
                result.append(decryptedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
