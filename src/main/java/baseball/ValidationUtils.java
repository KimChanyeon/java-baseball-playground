package baseball;

public class ValidationUtils {

    public static final int MIN_NO = 0;
    public static final int MAX_NO = 10;

    public static boolean validNo(int no) {
        return no > MIN_NO && no < MAX_NO;
    }

    public static boolean isDuplicate(int no1, int no2, int no3) {
        return no1 != no2 && no1 != no3 && no2 != no3;
    }
}
