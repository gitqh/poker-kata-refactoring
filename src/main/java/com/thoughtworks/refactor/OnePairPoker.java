package com.thoughtworks.refactor;

public class OnePairPoker extends Poker{
    @Override
    protected String compare(final Hand blackHand, final Hand whiteHand) {
        String winResult = "";
        if (blackHand.getRepeat()[0] < whiteHand.getRepeat()[0]) {
            String sig = intNumber(whiteHand.getRepeat()[0]);
            winResult = WHITE_WINS_HINTS + sig;
        } else if (blackHand.getRepeat()[0] > whiteHand.getRepeat()[0]) {
            String sig = intNumber(blackHand.getRepeat()[0]);
            winResult = BLACK_WINS_HINTS + sig;
        } else {
            for (int i = 0; i < 3; i++) {
                if (blackHand.getNoRepeat()[i] < whiteHand.getNoRepeat()[i]) {
                    String sig = intNumber(whiteHand.getNoRepeat()[i]);
                    winResult = WHITE_WINS_HINTS + sig;
                    break;
                } else if (blackHand.getNoRepeat()[i] > whiteHand.getNoRepeat()[i]) {
                    String sig = intNumber(blackHand.getNoRepeat()[i]);
                    winResult = BLACK_WINS_HINTS + sig;
                    break;
                } else {
                    winResult = "tie";
                }
            }
        }
        return winResult;
    }
}
