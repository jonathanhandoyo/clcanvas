package com.cs.codechallenge.clcanvas;

/**
 * Created by arnold on 20/8/17.
 */
public class Canvas {
    private char[][] charMap = {
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
    };

    public Canvas() {

    }

    public void setCharMap(char[][] charMap) {
        this.charMap = charMap;
    }

    public void put(int x, int y, char pix) {
        charMap[y][x] = pix;
    }

    public char getChar(int x, int y) {
        return charMap[y][x];
    }

    public void draw(){
        for(int row = 0; row < charMap.length; row++) {
            char[] colArr = charMap[row];

            for(int col = 0; col < colArr.length; col++) {
                System.out.print(colArr[col]);
            }
            System.out.println("");
        }
    }
}