package com.thoughtworks.refactor;

public class HighCardPoker extends Poker{
    @Override
    protected String compare(final Hand blackHand, final Hand whiteHand) {
        String winResult = "";
        for (int i = 0; i < 5; i++) {
            if (blackHand.getNumbers()[i] < whiteHand.getNumbers()[i]) {
                String sig = intNumber(whiteHand.getNumbers()[i]);
                winResult = WHITE_WINS_HINTS + sig;
                break;
            } else if (blackHand.getNumbers()[i] > whiteHand.getNumbers()[i]) {
                String sig = intNumber(blackHand.getNumbers()[i]);
                winResult = BLACK_WINS_HINTS + sig;
                break;
            } else {
                winResult = "tie";
            }
        }
        return winResult;
    }
}
