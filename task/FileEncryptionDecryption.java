
import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        char choice = scanner.next().charAt(0);

        if (choice == 'E' || choice == 'e') {
            System.out.print("Enter the input file name: ");
            String inputFileName = scanner.next();
            System.out.print("Enter the output file name: ");
            String outputFileName = scanner.next();
            encryptFile(inputFileName, outputFileName);
            System.out.println("File encrypted successfully!");
        } else if (choice == 'D' || choice == 'd') {
            System.out.print("Enter the input file name: ");
            String inputFileName = scanner.next();
            System.out.print("Enter the output file name: ");
            String outputFileName = scanner.next();
            decryptFile(inputFileName, outputFileName);
            System.out.println("File decrypted successfully!");
        } else {
            System.out.println("Invalid choice. Please enter 'E' for encryption or 'D' for decryption.");
        }

        scanner.close();
    }

    private static void encryptFile(String inputFileName, String outputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Encrypt each character in the line (for simplicity, we'll just shift each character by 1)
                StringBuilder encryptedLine = new StringBuilder();
                for (char c : line.toCharArray()) {
                    encryptedLine.append((char) (c + 1));
                }

                writer.write(encryptedLine.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decryptFile(String inputFileName, String outputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Decrypt each character in the line (for simplicity, we'll just shift each character back by 1)
                StringBuilder decryptedLine = new StringBuilder();
                for (char c : line.toCharArray()) {
                    decryptedLine.append((char) (c - 1));
                }

                writer.write(decryptedLine.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
