package com.thoughtworks.refactor;

public class ThreeOfAKindPoker extends Poker{
    @Override
    protected String compare(final Hand blackHand, final Hand whiteHand) {
        String winResult;
        if (blackHand.getRepeat()[0] < whiteHand.getRepeat()[0]) {
            String sig = intNumber(whiteHand.getRepeat()[0]);
            winResult = WHITE_WINS_HINTS + sig;
        } else {
            String sig = intNumber(blackHand.getRepeat()[0]);
            winResult = BLACK_WINS_HINTS + sig;
        }
        return winResult;
    }
}
