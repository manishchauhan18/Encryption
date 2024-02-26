import java.security.*;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;

public class RSA {

    public static void main(String[] args) {
        try {
            System.out.println("KEY GENERATION");
            KeyPair keyPair = generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            System.out.println("\nPublic Key:");
            System.out.println(getPublicKeyString(publicKey));
            System.out.println();
            System.out.println("Private Key:");
            System.out.println(getPrivateKeyString(privateKey));

            System.out.println("\nRSA ENCRYPTION");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Plain Text to Encrypt:");
            String plainText = scanner.nextLine();
            System.out.println("Enter Public/Private key:");
            String publicKeyStr = scanner.nextLine();
            if (!publicKeyStr.equals(getPublicKeyString(publicKey))) {
                throw new IllegalArgumentException("Invalid public key.");
            }
            String encryptedText = encrypt(plainText, publicKey);

            System.out.println("\nEncrypted Output:");
            System.out.println(encryptedText);

            System.out.println("\nRSA DECRYPTION");
            System.out.println("Enter Encrypted Text to Decrypt:");
            String encryptedInput = scanner.nextLine();
            System.out.println("Enter Public/Private key:");
            String privateKeyStr = scanner.nextLine();
            if (!privateKeyStr.equals(getPrivateKeyString(privateKey))) {
                throw new IllegalArgumentException("Invalid private key.");
            }
            String decryptedText = decrypt(encryptedInput, privateKey);

            System.out.println("\nDecrypted Output:");
            System.out.println(decryptedText);

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decrypt(String encryptedText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(encryptedText);
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = decryptCipher.doFinal(bytes);
        return new String(decryptedBytes);
    }

    public static String getPublicKeyString(PublicKey publicKey) {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    public static String getPrivateKeyString(PrivateKey privateKey) {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }
}
