package com.thoughtworks.refactor;

public class TwoPairPoker extends Poker{
    @Override
    protected String compare(final Hand blackHand, final Hand whiteHand) {
        String winResult = "";
        for (int i = 0; i < 2; i++) {
            if (blackHand.getRepeat()[i] < whiteHand.getRepeat()[i]) {
                String sig = intNumber(whiteHand.getRepeat()[i]);
                winResult = WHITE_WINS_HINTS + sig;
                break;
            } else if (blackHand.getRepeat()[i] > whiteHand.getRepeat()[i]) {
                String sig = intNumber(blackHand.getRepeat()[i]);
                winResult = BLACK_WINS_HINTS + sig;
                break;
            }
        }
        if (winResult == "") {
            if (blackHand.getNoRepeat()[0] < whiteHand.getNoRepeat()[0]) {
                String sig = intNumber(whiteHand.getNoRepeat()[0]);
                winResult = WHITE_WINS_HINTS + sig;
            } else if (blackHand.getNoRepeat()[0] > whiteHand.getNoRepeat()[0]) {
                String sig = intNumber(blackHand.getNoRepeat()[0]);
                winResult = BLACK_WINS_HINTS + sig;
            } else {
                winResult = "tie";
            }
        }
        return winResult;
    }
}
