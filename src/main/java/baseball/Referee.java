package baseball;

import java.util.List;

public class Referee {

    public static final String NOTHING = "NOTHING";
    private int strike;
    private int ball;

    public String getResult(Balls user, Balls com) {
        clear();
        calculate(user, com);

        return getResultByStrikeAndBall();
    }

    private void clear() {
        strike = 0;
        ball = 0;
    }

    private void calculate(Balls user, Balls com) {
        List<Ball> userBalls = user.getBallList();
        List<Ball> comBalls = com.getBallList();

        for (int userIndex = 0; userIndex < userBalls.size(); userIndex++) {
            checkStrikeAndBall(userBalls.get(userIndex), comBalls, userIndex);
        }
    }

    private void checkStrikeAndBall(Ball userBall, List<Ball> comBalls, int userIndex) {
        for (int comIndex = 0; comIndex < comBalls.size(); comIndex++) {
            compareBalls(userBall, comBalls.get(comIndex), userIndex, comIndex);
        }
    }

    private void compareBalls(Ball userBall, Ball comBall, int userIndex, int comIndex) {
        if (isStrike(userBall, comBall, userIndex, comIndex)) {
            strike++;
        }

        if (isBall(userBall, comBall, userIndex, comIndex)) {
            ball++;
        }
    }

    private static boolean isStrike(Ball userBall, Ball comBall, int userIndex, int comIndex) {
        return userBall.equals(comBall) && userIndex == comIndex;
    }

    private static boolean isBall(Ball userBall, Ball comBall, int userIndex, int comIndex) {
        return userBall.equals(comBall) && userIndex != comIndex;
    }

    private String getResultByStrikeAndBall() {
        if (!hasStrike() && !hasBall()) {
            return NOTHING;
        }

        StringBuilder result = new StringBuilder();
        if (hasStrike()) {
            result.append(strike).append("S");
        }
        if (hasBall()) {
            result.append(ball).append("B");
        }

        return result.toString();
    }

    private boolean hasStrike() {
        return strike > 0;
    }

    private boolean hasBall() {
        return ball > 0;
    }
}
