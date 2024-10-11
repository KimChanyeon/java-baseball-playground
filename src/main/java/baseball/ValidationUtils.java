package baseball;

public class ValidationUtils {

    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;
    public static final int MIN_THREE_PLACE = 100;
    public static final int MAX_THREE_PLACE = 999;

    public static boolean validNo(int no) {
        return no >= MIN_NO && no <= MAX_NO;
    }

    public static boolean isDuplicate(int no1, int no2, int no3) {
        return no1 != no2 && no1 != no3 && no2 != no3;
    }

    public static boolean isThreePlace(int no) {
        return no >= MIN_THREE_PLACE && no <= MAX_THREE_PLACE;
    }
}
