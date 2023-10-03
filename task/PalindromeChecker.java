import java.util.Scanner;
import java.util.regex.Pattern;

public class PalindromeChecker {

    public static void main(String[] args) {
        // Accept user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String userInput = scanner.nextLine();
        scanner.close();

        if (isPalindrome(userInput)) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String input) {
        // Remove spaces and punctuation
        input = input.replaceAll("[^a-zA-Z]", "");

        // Convert to lowercase
        input = input.toLowerCase();

        // Check if it's a palindrome
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
