package com.thoughtworks.refactor;

import java.util.Arrays;

public class Hand {
    private String type;
    private String numbers;
    private int index;
    private int[] arraySort;
    private int[] repeat;
    private int[] noRepeat;

    //数字转化并将其从大到小排序
    static int[] strNumber(String str) {
        int[] number = new int[5];
        String[] strArray = str.split("");
        int i;
        for (i = 0; i < 5; i++) {
            String c = strArray[i * 3];
            switch (c) {
                case "T":
                    number[i] = 10;
                    break;
                case "J":
                    number[i] = 11;
                    break;
                case "Q":
                    number[i] = 12;
                    break;
                case "K":
                    number[i] = 13;
                    break;
                case "A":
                    number[i] = 14;
                    break;
                default:
                    number[i] = Integer.valueOf(c);
                    break;
            }
        }

        Arrays.sort(number);
        int[] renumber = new int[number.length];
        for (i = 0; i < number.length; i++) {
            renumber[i] = number[number.length - i - 1];
        }
        return renumber;
    }

    public String getType() {
        return type;
    }

    public String getNumbers() {
        return numbers;
    }

    public int getIndex() {
        return index;
    }

    public int[] getArraySort() {
        return arraySort;
    }

    public int[] getRepeat() {
        return repeat;
    }

    public int[] getNoRepeat() {
        return noRepeat;
    }
}
