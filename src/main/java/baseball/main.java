package baseball;

import utils.ValidationUtil;

import java.util.Scanner;

public class main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Balls com = new Balls();
        Balls user = new Balls();
        Referee referee = new Referee();

        while (true) {
            com.initByRandom();
            if(!start(user, referee, com)) break;
        }

    }

    private static boolean start(Balls user, Referee referee, Balls com) {
        String result = "";
        String userInput = "";
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

        System.out.println();
        System.out.println("다시 시작하시려면 1, 종료 하시려면 2를 입력하세요.");

        boolean flag = scanner.nextInt() == 1;
        scanner.nextLine();

        return flag;
    }
}
