package com.thoughtworks.refactor;

public class Poker {

    protected static final String WINS_HINTS = " wins - high card:";
    protected static final String WHITE_WINS_HINTS = "white" + WINS_HINTS;
    protected static final String BLACK_WINS_HINTS = "black" + WINS_HINTS;

    public String compareResult(String black, String white) {
        final Hand blackHand = new Hand(black);
        final Hand whiteHand = new Hand(white);

        String winResult = "";
        if (blackHand.getIndex() < whiteHand.getIndex()) {
            winResult = "black wins - " + Hand.CARD_TYPES[blackHand.getIndex()];
        } else if (blackHand.getIndex() > whiteHand.getIndex()) {
            winResult = "white wins - " + Hand.CARD_TYPES[whiteHand.getIndex()];
        } else {
            winResult = compareWithSameCardType(blackHand, whiteHand);
        }
        return winResult;
    }

    protected String compare(final Hand blackHand, final Hand whiteHand) {
        return null;
    }
    private String compareWithSameCardType(final Hand blackHand, final Hand whiteHand) {
        String winResult;
        Poker poker;
        if (blackHand.getIndex() == 0) { //同花顺
            poker = new StraightFlushPoker();
            winResult = poker.compare(blackHand, whiteHand);
        } else if (blackHand.getIndex() == 1) { //铁支
            poker = new FourOfAKindPoker();
            winResult = poker.compare(blackHand, whiteHand);
        } else if (blackHand.getIndex() == 2) { //葫芦
            poker = new FullHousePoker();
            winResult = poker.compare(blackHand, whiteHand);
        } else if (blackHand.getIndex() == 3) { //同花
            poker = new FlushPoker();
            winResult = poker.compare(blackHand, whiteHand);
        } else if (blackHand.getIndex() == 4) { //顺子
            poker = new StraightPoker();
            winResult = poker.compare(blackHand, whiteHand);
        } else if (blackHand.getIndex() == 5) { //三条
            poker = new ThreeOfAKindPoker();
            winResult = poker.compare(blackHand, whiteHand);
        } else if (blackHand.getIndex() == 6) { //两对
            poker = new TwoPairPoker();
            winResult = poker.compare(blackHand, whiteHand);
        } else if (blackHand.getIndex() == 7) { //对子
            poker = new OnePairPoker();
            winResult = poker.compare(blackHand, whiteHand);
        } else { //散牌
            winResult = compareHighCard(blackHand, whiteHand);
        }
        return winResult;
    }

    private String compareHighCard(final Hand blackHand, final Hand whiteHand) {
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

    protected String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

}
