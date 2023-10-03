import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit and Kelvin");
        System.out.println("2. Fahrenheit to Celsius and Kelvin");
        System.out.println("3. Kelvin to Celsius and Fahrenheit");
        System.out.print("Choose an option (1/2/3): ");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                convertCelsius();
                break;
            case 2:
                convertFahrenheit();
                break;
            case 3:
                convertKelvin();
                break;
            default:
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
                break;
        }
    }

    public static void convertCelsius() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin = celsius + 273.15;

        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Kelvin: " + kelvin);
    }

    public static void convertFahrenheit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (fahrenheit - 32) * 5/9;
        double kelvin = (fahrenheit + 459.67) * 5/9;

        System.out.println("Celsius: " + celsius);
        System.out.println("Kelvin: " + kelvin);
    }

    public static void convertKelvin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Kelvin: ");
        double kelvin = scanner.nextDouble();
        double celsius = kelvin - 273.15;
        double fahrenheit = (kelvin * 9/5) - 459.67;

        System.out.println("Celsius: " + celsius);
        System.out.println("Fahrenheit: " + fahrenheit);
    }
}
