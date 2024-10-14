package baseball;

import utils.ValidationUtil;

import java.util.Scanner;

public class main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Balls com = new Balls();
        com.initByRandom();

        Balls user = new Balls();

        Referee referee = new Referee();

        String userInput = "";
        String result = "";

        while (!result.equals("3S")) {
            System.out.println("숫자를 입력하세요");
            userInput = scanner.nextLine();

            while (!ValidationUtil.validInput(userInput)) {
                System.out.println("서로다른 세자리 숫자를 입력해야 합니다.");
                System.out.println("숫자를 입력하세요");
                userInput = scanner.nextLine();
            }

            user.initByInput(userInput);

            result = referee.getResult(user, com);

            System.out.println(result);
        }

    }
}
