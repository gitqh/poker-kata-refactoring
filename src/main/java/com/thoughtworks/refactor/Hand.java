package com.thoughtworks.refactor;

public class Hand {
    private String type;
    private String numbers;
    private int index;
    private int[] arraySort;
    private int[] repeat;
    private int[] noRepeat;

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
