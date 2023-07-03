package com.thoughtworks.refactor;

public class Poker {

    private static final String WINS_HINTS = " wins - high card:";
    private static final String WHITE_WINS_HINTS = "white" + WINS_HINTS;
    private static final String BLACK_WINS_HINTS = "black" + WINS_HINTS;

    public String compareResult(String black, String white) {
        final Hand blackHand = new Hand(black);
        final Hand whiteHand = new Hand(white);

        String winResult = "";
        if (blackHand.getIndex() < whiteHand.getIndex()) {
            winResult = "black wins - " + Hand.CARD_TYPES[blackHand.getIndex()];
        } else if (blackHand.getIndex() > whiteHand.getIndex()) {
            winResult = "white wins - " + Hand.CARD_TYPES[whiteHand.getIndex()];
        } else {
            if (blackHand.getIndex() == 0) { //同花顺
                winResult = compareStraightFlush(blackHand, whiteHand);
            } else if (blackHand.getIndex() == 1) { //铁支
                winResult = compareFourOfAKind(blackHand, whiteHand);
            } else if (blackHand.getIndex() == 2) { //葫芦
                winResult = compareFullHouse(blackHand, whiteHand);
            } else if (blackHand.getIndex() == 3) { //同花
                winResult = compareFlush(blackHand, whiteHand, winResult);
            } else if (blackHand.getIndex() == 4) { //顺子
                winResult = compareStraight(blackHand, whiteHand);
            } else if (blackHand.getIndex() == 5) { //三条
                winResult = compareThreeOfAKind(blackHand, whiteHand);
            } else if (blackHand.getIndex() == 6) { //两对
                winResult = compareTwoPair(blackHand, whiteHand);
            } else if (blackHand.getIndex() == 7) { //对子
                winResult = compareOnePair(blackHand, whiteHand, winResult);
            } else { //散牌
                winResult = compareHighCard(blackHand, whiteHand, winResult);
            }
        }
        return winResult;
    }

    private String compareHighCard(final Hand blackHand, final Hand whiteHand, String winResult) {
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

    private String compareOnePair(final Hand blackHand, final Hand whiteHand, String winResult) {
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

    private String compareTwoPair(final Hand blackHand, final Hand whiteHand) {
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

    private String compareThreeOfAKind(final Hand blackHand, final Hand whiteHand) {
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

    private String compareStraight(final Hand blackHand, final Hand whiteHand) {
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

    private String compareFlush(final Hand blackHand, final Hand whiteHand, String winResult) {
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

    private String compareFullHouse(final Hand blackHand, final Hand whiteHand) {
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

    private String compareFourOfAKind(final Hand blackHand, final Hand whiteHand) {
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

    private String compareStraightFlush(final Hand blackHand, final Hand whiteHand) {
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

    private String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

}
