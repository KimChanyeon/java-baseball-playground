package baseball;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Referee referee = new Referee();
        Random random = new Random();
        referee.init(random);
        while (flag) {
            String input = InputView.getInput();
            String result = referee.getResult(input);
            System.out.println(result);

            flag = continueOrExit(result, referee, random, flag);
        }
    }

    private static boolean continueOrExit(String result, Referee referee, Random random, boolean flag) {
        if (result.equals("3S")) {
            flag = getUserDecision(referee, random);
        }
        return flag;
    }

    private static boolean getUserDecision(Referee referee, Random random) {
        if (ResultView.printResult() == 1) {
            referee.init(random);
            return true;
        }
        return false;
    }
}
