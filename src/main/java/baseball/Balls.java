package baseball;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    
    private final List<Ball> ballList;

    public Balls() {
        this.ballList = new ArrayList<>();
    }

    public void initByRandom() {
        SecureRandom random = new SecureRandom();
        while (!valid()) {
            clear();
            for (int i = 0; i < 3; i++) {
                addBall(random.nextInt(9) + 1);
            }
        }
    }

    public void initByInput(String input) {
        clear();
        for (int i = 0; i < 3; i++) {
            addBall(Character.digit(input.charAt(i), 10));
        }
    }

    public boolean valid() {
        boolean valid = false;

        if (ballList.size() != 3) {
            return valid;
        }

        if (ballsNotDuplicate()) {
            valid = true;
        }

        return valid;
    }

    private void addBall(int number1) {
        ballList.add(new Ball(number1));
    }

    private void clear() {
        ballList.clear();
    }

    private boolean ballsNotDuplicate() {
        return !ballList.get(0).equals(ballList.get(1)) && !ballList.get(0).equals(ballList.get(2)) && !ballList.get(1).equals(ballList.get(2));
    }

    public List<Ball> getBallList() {
        return ballList;
    }
}
