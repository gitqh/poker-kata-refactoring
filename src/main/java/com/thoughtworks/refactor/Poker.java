package com.thoughtworks.refactor;

public class Poker {

    private static final String WINS_HINTS = " wins - high card:";
    private static final String WHITE_WINS_HINTS = "white" + WINS_HINTS;
    private static final String BLACK_WINS_HINTS = "black" + WINS_HINTS;

    public String compareResult(String black, String white) {
        final Hand blackHand = new Hand(black);
        int[] blackNumber = blackHand.getNumbers();
        int blackIndex = blackHand.getIndex();
        int[] blackArraySort = blackHand.getArraySort();
        int[] blackRepeat = blackHand.getRepeat();
        int[] blackNoRepeat = blackHand.getNoRepeat();

        final Hand whiteHand = new Hand(white);
        int[] whiteNumber = whiteHand.getNumbers();
        int whiteIndex = whiteHand.getIndex();
        int[] whiteArraySort = whiteHand.getArraySort();
        int[] whiteRepeat = whiteHand.getRepeat();
        int[] whiteNoRepeat = whiteHand.getNoRepeat();

        String winResult = "";
        if (blackIndex < whiteIndex) {
            winResult = "black wins - " + Hand.CARD_TYPES[blackIndex];
        } else if (blackIndex > whiteIndex) {
            winResult = "white wins - " + Hand.CARD_TYPES[whiteIndex];
        } else {
            if (blackIndex == 0) { //同花顺
                if (blackNumber[0] < whiteNumber[0]) {
                    String sig = intNumber(whiteNumber[0]);
                    winResult = WHITE_WINS_HINTS + sig;
                } else if (blackNumber[0] > whiteNumber[0]) {
                    String sig = intNumber(blackNumber[0]);
                    winResult = BLACK_WINS_HINTS + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackIndex == 1) { //铁支
                if (blackArraySort[0] < whiteArraySort[0]) {
                    String sig = intNumber(whiteArraySort[0]);
                    winResult = WHITE_WINS_HINTS + sig;
                } else {
                    String sig = intNumber(blackArraySort[0]);
                    winResult = BLACK_WINS_HINTS + sig;
                }
            } else if (blackIndex == 2) { //葫芦
                if (blackArraySort[0] < whiteArraySort[0]) {
                    String sig = intNumber(whiteArraySort[0]);
                    winResult = WHITE_WINS_HINTS + sig;
                } else {
                    String sig = intNumber(blackArraySort[0]);
                    winResult = BLACK_WINS_HINTS + sig;
                }
            } else if (blackIndex == 3) { //同花
                for (int i = 0; i < 5; i++) {
                    if (blackNumber[i] < whiteNumber[i]) {
                        String sig = intNumber(whiteNumber[i]);
                        winResult = WHITE_WINS_HINTS + sig;
                        break;
                    } else if (blackNumber[i] > whiteNumber[i]) {
                        String sig = intNumber(blackNumber[i]);
                        winResult = BLACK_WINS_HINTS + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackIndex == 4) { //顺子
                if (blackNumber[0] < whiteNumber[0]) {
                    String sig = intNumber(whiteNumber[0]);
                    winResult = WHITE_WINS_HINTS + sig;
                } else if (blackNumber[0] > whiteNumber[0]) {
                    String sig = intNumber(blackNumber[0]);
                    winResult = BLACK_WINS_HINTS + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackIndex == 5) { //三条
                if (blackRepeat[0] < whiteRepeat[0]) {
                    String sig = intNumber(whiteRepeat[0]);
                    winResult = WHITE_WINS_HINTS + sig;
                } else {
                    String sig = intNumber(blackRepeat[0]);
                    winResult = BLACK_WINS_HINTS + sig;
                }
            } else if (blackIndex == 6) { //两对
                for (int i = 0; i < 2; i++) {
                    if (blackRepeat[i] < whiteRepeat[i]) {
                        String sig = intNumber(whiteRepeat[i]);
                        winResult = WHITE_WINS_HINTS + sig;
                        break;
                    } else if (blackRepeat[i] > whiteRepeat[i]) {
                        String sig = intNumber(blackRepeat[i]);
                        winResult = BLACK_WINS_HINTS + sig;
                        break;
                    }
                }
                if (winResult == "") {
                    if (blackNoRepeat[0] < whiteNoRepeat[0]) {
                        String sig = intNumber(whiteNoRepeat[0]);
                        winResult = WHITE_WINS_HINTS + sig;
                    } else if (blackNoRepeat[0] > whiteNoRepeat[0]) {
                        String sig = intNumber(blackNoRepeat[0]);
                        winResult = BLACK_WINS_HINTS + sig;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackIndex == 7) { //对子
                if (blackRepeat[0] < whiteRepeat[0]) {
                    String sig = intNumber(whiteRepeat[0]);
                    winResult = WHITE_WINS_HINTS + sig;
                } else if (blackRepeat[0] > whiteRepeat[0]) {
                    String sig = intNumber(blackRepeat[0]);
                    winResult = BLACK_WINS_HINTS + sig;
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (blackNoRepeat[i] < whiteNoRepeat[i]) {
                            String sig = intNumber(whiteNoRepeat[i]);
                            winResult = WHITE_WINS_HINTS + sig;
                            break;
                        } else if (blackNoRepeat[i] > whiteNoRepeat[i]) {
                            String sig = intNumber(blackNoRepeat[i]);
                            winResult = BLACK_WINS_HINTS + sig;
                            break;
                        } else {
                            winResult = "tie";
                        }
                    }
                }
            } else { //散牌
                for (int i = 0; i < 5; i++) {
                    if (blackNumber[i] < whiteNumber[i]) {
                        String sig = intNumber(whiteNumber[i]);
                        winResult = WHITE_WINS_HINTS + sig;
                        break;
                    } else if (blackNumber[i] > whiteNumber[i]) {
                        String sig = intNumber(blackNumber[i]);
                        winResult = BLACK_WINS_HINTS + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            }
        }
        return winResult;
    }

    private String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

}
