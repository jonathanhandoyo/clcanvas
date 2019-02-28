package com.cs.codechallenge.clcanvas.commands;

import com.cs.codechallenge.clcanvas.Canvas;

/**
 * Created by arnold on 20/8/17.
 */
public class DrawCanvasCommand implements Command {
    private Canvas canvas;
    private int width = 20;
    private int height = 4;
    private char horizontalBorder;
    private char verticalBorder;

    public DrawCanvasCommand(Canvas canvas, int width, int height, char horizontalBorder, char verticalBorder) {
        this.canvas = canvas;
        this.width = width;
        this.height = height;
        this.horizontalBorder = horizontalBorder;
        this.verticalBorder = verticalBorder;
    }

    @Override
    public void execute() {
        int areaHeight = this.height + 2;
        int areaWidth = this.width + 2;
        char[][] charMap = new char[areaHeight][areaWidth];

        // draw top border
        for (int col = 0; col < areaWidth; col++ ) {
            charMap[0][col] = this.horizontalBorder;
        }

        // draw bottom border
        for (int col = 0; col < areaWidth; col++ ) {
            charMap[areaHeight-1][col] = this.horizontalBorder;
        }

        // draw left border
        for (int row = 1; row < areaHeight-1; row++ ) {
            charMap[row][0] = this.verticalBorder;
        }

        // draw right border
        for (int row = 1; row < areaHeight-1; row++ ) {
            charMap[row][areaWidth-1] = this.verticalBorder;
        }

        for(int row = 1; row <= this.height; row++) {
            for(int col = 1; col <= this.width; col++) {
                charMap[row][col] = ' ';
            }
        }

        canvas.setCharMap(charMap);

    }

}