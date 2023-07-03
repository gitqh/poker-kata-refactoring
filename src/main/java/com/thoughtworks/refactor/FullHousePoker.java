package com.thoughtworks.refactor;

public class FullHousePoker extends Poker{
    @Override
    protected String compare(final Hand blackHand, final Hand whiteHand) {
        String winResult;
        if (blackHand.getArraySort()[0] < whiteHand.getArraySort()[0]) {
            String sig = intNumber(whiteHand.getArraySort()[0]);
            winResult = WHITE_WINS_HINTS + sig;
        } else {
            String sig = intNumber(blackHand.getArraySort()[0]);
            winResult = BLACK_WINS_HINTS + sig;
        }
        return winResult;
    }
}
