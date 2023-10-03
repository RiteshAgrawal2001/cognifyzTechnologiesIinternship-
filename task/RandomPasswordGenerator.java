import java.security.SecureRandom;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        int passwordLength = 12; // You can change the length of the password as needed
        String password = generateRandomPassword(passwordLength);
        System.out.println("Random Password: " + password);
    }

    // Function to generate a random password
    public static String generateRandomPassword(int length) {
        // Define the character sets for the password
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        // Combine all the character sets
        String allChars = lowercaseChars + uppercaseChars + digits + specialChars;

        // Create a SecureRandom instance for generating random numbers
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        // Generate the password by randomly selecting characters from the character set
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            char randomChar = allChars.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
