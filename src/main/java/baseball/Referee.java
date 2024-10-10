package baseball;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Referee {

    private static final String ARGUMENT_ERROR = "입력은 세자리의 숫자로 이루어져야 합니다.";

    private int number1;
    private int number2;
    private int number3;

    public Referee() {

    }

    public void init(Random random) {
        number1 = getRandomNumber(random);

        do {
            number2 = getRandomNumber(random);
        } while (number1 == number2);

        do {
            number3 = getRandomNumber(random);
        } while (number2 == number3 || number1 == number3);
    }

    public String getResult(String input) {

        char[] inputCharArray = input.toCharArray();
        int[] inputs = new int[inputCharArray.length];
        checkInputValid(inputCharArray.length != 3);

        for (int i = 0; i < inputCharArray.length; i++) {
            char c = inputCharArray[i];
            checkInputValid(!Character.isDigit(c));

            int digit = Character.digit(c, 10);
            checkInputValid(digit < 1 || digit > 9);

            setInputByIndex(i, digit, inputs);
        }

        StringBuilder sb = getResultSb(inputs);

        return sb.toString();
    }

    private StringBuilder getResultSb(int[] inputs) {
        int s = 0;
        int b = 0;

        if (inputs[0] == number1) s++;
        if (inputs[0] == number2 || inputs[0] == number3) b++;

        if (inputs[1] == number2) s++;
        if (inputs[1] == number1 || inputs[1] == number3) b++;

        if (inputs[2] == number3) s++;
        if (inputs[2] == number1 || inputs[2] == number2) b++;

        StringBuilder sb = new StringBuilder();

        if (s > 0) {
            sb.append(s);
            sb.append("S");
        }

        if (b > 0) {
            sb.append(b);
            sb.append("B");
        }

        if (s == 0 && b == 0) {
            sb.append("NOTHING");
        }
        return sb;
    }

    private void setInputByIndex(int index, int value, int[] inputs) {
        inputs[index] = value;
    }

    private static void checkInputValid(boolean c) {
        if (c) {
            throw new IllegalArgumentException(ARGUMENT_ERROR);
        }
    }

    private int getRandomNumber(Random random) {
        return random.nextInt(9) + 1;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", number3=" + number3 +
                '}';
    }
}
