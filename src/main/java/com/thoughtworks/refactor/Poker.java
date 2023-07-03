package com.thoughtworks.refactor;

public class Poker {

    public String compareResult(String black, String white) {
        String blackType = Hand.judgeType(black);
        int[] blackNumber = Hand.strNumber(black);
        int blackIndex = Hand.judgeIndex(blackType);
        int[] blackArraySort = Hand.arraySort(blackNumber);
        int[] blackRepeat = Hand.noOrRepeatNumber(blackNumber, 0);
        int[] blackNoRepeat = Hand.noOrRepeatNumber(blackNumber, 1);

        String whiteType = Hand.judgeType(white);
        int[] whiteNumber = Hand.strNumber(white);
        int whiteIndex = Hand.judgeIndex(whiteType);
        int[] whiteArraySort = Hand.arraySort(whiteNumber);
        int[] whiteRepeat = Hand.noOrRepeatNumber(whiteNumber, 0);
        int[] whiteNoRepeat = Hand.noOrRepeatNumber(whiteNumber, 1);

        String winResult = "";
        if (blackIndex < whiteIndex) {
            winResult = "black wins - " + Hand.CARD_TYPES[blackIndex];
        } else if (blackIndex > whiteIndex) {
            winResult = "white wins - " + Hand.CARD_TYPES[whiteIndex];
        } else {
            if (blackIndex == 0) { //同花顺
                if (blackNumber[0] < whiteNumber[0]) {
                    String sig = intNumber(whiteNumber[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackNumber[0] > whiteNumber[0]) {
                    String sig = intNumber(blackNumber[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackIndex == 1) { //铁支
                if (blackArraySort[0] < whiteArraySort[0]) {
                    String sig = intNumber(whiteArraySort[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(blackArraySort[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackIndex == 2) { //葫芦
                if (blackArraySort[0] < whiteArraySort[0]) {
                    String sig = intNumber(whiteArraySort[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(blackArraySort[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackIndex == 3) { //同花
                for (int i = 0; i < 5; i++) {
                    if (blackNumber[i] < whiteNumber[i]) {
                        String sig = intNumber(whiteNumber[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackNumber[i] > whiteNumber[i]) {
                        String sig = intNumber(blackNumber[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackIndex == 4) { //顺子
                if (blackNumber[0] < whiteNumber[0]) {
                    String sig = intNumber(whiteNumber[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackNumber[0] > whiteNumber[0]) {
                    String sig = intNumber(blackNumber[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackIndex == 5) { //三条
                if (blackRepeat[0] < whiteRepeat[0]) {
                    String sig = intNumber(whiteRepeat[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(blackRepeat[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackIndex == 6) { //两对
                for (int i = 0; i < 2; i++) {
                    if (blackRepeat[i] < whiteRepeat[i]) {
                        String sig = intNumber(whiteRepeat[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackRepeat[i] > whiteRepeat[i]) {
                        String sig = intNumber(blackRepeat[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    }
                }
                if (winResult == "") {
                    if (blackNoRepeat[0] < whiteNoRepeat[0]) {
                        String sig = intNumber(whiteNoRepeat[0]);
                        winResult = "white wins - high card:" + sig;
                    } else if (blackNoRepeat[0] > whiteNoRepeat[0]) {
                        String sig = intNumber(blackNoRepeat[0]);
                        winResult = "black wins - high card:" + sig;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackIndex == 7) { //对子
                if (blackRepeat[0] < whiteRepeat[0]) {
                    String sig = intNumber(whiteRepeat[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackRepeat[0] > whiteRepeat[0]) {
                    String sig = intNumber(blackRepeat[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (blackNoRepeat[i] < whiteNoRepeat[i]) {
                            String sig = intNumber(whiteNoRepeat[i]);
                            winResult = "white wins - high card:" + sig;
                            break;
                        } else if (blackNoRepeat[i] > whiteNoRepeat[i]) {
                            String sig = intNumber(blackNoRepeat[i]);
                            winResult = "black wins - high card:" + sig;
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
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackNumber[i] > whiteNumber[i]) {
                        String sig = intNumber(blackNumber[i]);
                        winResult = "black wins - high card:" + sig;
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
