import java.util.regex.*;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        String password = "MyStrongP@ssw0rd";
        PasswordStrength strength = checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);
    }

    public static PasswordStrength checkPasswordStrength(String password) {
        if (password == null || password.isEmpty()) {
            return PasswordStrength.WEAK;
        }

        int length = password.length();
        if (length < 8) {
            return PasswordStrength.WEAK;
        }

        if (!containsUppercase(password) || !containsLowercase(password) || !containsDigit(password) || !containsSpecialCharacter(password)) {
            return PasswordStrength.MEDIUM;
        }

        return PasswordStrength.STRONG;
    }

    private static boolean containsUppercase(String password) {
        return !password.equals(password.toLowerCase());
    }

    private static boolean containsLowercase(String password) {
        return !password.equals(password.toUpperCase());
    }

    private static boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean containsSpecialCharacter(String password) {
        Pattern pattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public enum PasswordStrength {
        WEAK, MEDIUM, STRONG
    }
}
