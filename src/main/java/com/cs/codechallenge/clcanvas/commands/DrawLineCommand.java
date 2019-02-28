package com.cs.codechallenge.clcanvas.commands;

import com.cs.codechallenge.clcanvas.Canvas;

/**
 * Created by arnold on 20/8/17.
 */
public class DrawLineCommand implements Command {
    private Canvas canvas = new Canvas();
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private char pix;

    public DrawLineCommand(Canvas canvas, int x1, int y1, int x2, int y2, char pix) throws IllegalArgumentException{
        if(!(x1 == x2 || y1 == y2)) throw new IllegalArgumentException("Diagonal line is not supported");

        this.canvas = canvas;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.pix = pix;
    }

    @Override
    public void execute() {
        if(x1 == x2) {
            int start = y1 > y2 ? y2 : y1;
            int end = y1 > y2 ? y1 : y2;
            for(int i = start; i <= end; i++) {
                canvas.put(x1, i, pix);
            }
        } else {
            int start = x1 > x2 ? x2 : x1;
            int end = x1 > x2 ? x1 : x2;
            for(int i = start; i <= end; i++) {
                canvas.put(i, y1, pix);
            }
        }
    }
}
