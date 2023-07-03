package com.thoughtworks.refactor;

public class StraightPoker extends Poker{
    @Override
    protected String compare(final Hand blackHand, final Hand whiteHand) {
        String winResult;
        if (blackHand.getNumbers()[0] < whiteHand.getNumbers()[0]) {
            String sig = intNumber(whiteHand.getNumbers()[0]);
            winResult = WHITE_WINS_HINTS + sig;
        } else if (blackHand.getNumbers()[0] > whiteHand.getNumbers()[0]) {
            String sig = intNumber(blackHand.getNumbers()[0]);
            winResult = BLACK_WINS_HINTS + sig;
        } else {
            winResult = "tie";
        }
        return winResult;
    }
}
