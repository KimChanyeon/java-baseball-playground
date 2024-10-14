package utils;

public class ValidationUtil {
    public static boolean validInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        if (!isThreePlace(input)) {
            return false;
        }

        if (!isDigit(input)) {
            return false;
        }

        return eachUnique(input);
    }

    private static boolean eachUnique(String input) {
        int number1 = Character.digit(input.charAt(0), 10);
        int number2 = Character.digit(input.charAt(1), 10);
        int number3 = Character.digit(input.charAt(2), 10);
        return number1 != number2 && number1 != number3 && number2 != number3;
    }

    private static boolean isDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isThreePlace(String input) {
        return input.length() == 3;
    }
}
