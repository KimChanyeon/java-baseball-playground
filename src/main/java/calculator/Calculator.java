package calculator;

import java.util.*;

public class Calculator {

    public int process(String str) {
        Queue<Integer> numberQueue = getNumberQueue(str);
        Queue<String> symbolQueue = getSymbolQueue(str);

        int result = 0;
        if (!numberQueue.isEmpty()) {
            result = numberQueue.poll();
        }

        while (true) {
            String symbol = symbolQueue.poll();
            Integer target = numberQueue.poll();
            if (symbol != null && target != null) {
                result = calculate(result, symbol, target);
                continue;
            }
            break;
        }

        return result;
    }

    public int calculate(int a, String symbol, int b) {
        if (symbol.equals("+")) return a + b;
        if (symbol.equals("-")) return a - b;
        if (symbol.equals("*")) return a * b;
        if (symbol.equals("/")) return a / b;
        throw new RuntimeException("Unknown symbol: " + symbol);
    }

    public Queue<String> getSymbolQueue(String str) {
        String[] split = str.split(" ");
        Queue<String> symbolQueue = new ArrayDeque<>();
        for (String s : split) {
            if (isSymbols(s)) symbolQueue.offer(s);
        }

        return symbolQueue;
    }

    public Queue<Integer> getNumberQueue(String str) {
        String[] split = str.split(" ");
        Queue<Integer> numberQueue = new ArrayDeque<>();
        for (String s : split) {
            if (isNumber(s)) numberQueue.offer(Integer.parseInt(s));
        }

        return numberQueue;
    }

    private boolean isSymbols(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static boolean isNumber(String s) {
        return s.matches("[0-9]+");
    }

}
