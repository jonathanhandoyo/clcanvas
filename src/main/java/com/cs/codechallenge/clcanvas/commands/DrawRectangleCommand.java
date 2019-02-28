package com.cs.codechallenge.clcanvas.commands;

import com.cs.codechallenge.clcanvas.Canvas;

/**
 * Created by arnold on 20/8/17.
 */
public class DrawRectangleCommand implements Command {
    private Canvas canvas = new Canvas();
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private char pix;

    public DrawRectangleCommand(Canvas canvas, int x1, int y1, int x2, int y2, char pix) {
        this.canvas = canvas;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.pix = pix;

    }

    @Override
    public void execute() {
        int[] xs = x1 > x2 ? new int[]{x2, x1} : new int[]{x1, x2};
        int[] ys = y1 > y2 ? new int[]{y2, y1} : new int[]{y1, y2};

        for(int x = xs[0]; x <= xs[1]; x++) {
            canvas.put(x, ys[0], pix);
        }

        for(int y = ys[0]; y <= ys[1]; y++) {
            canvas.put(xs[1], y, pix);
        }

        for(int x = xs[1]-1; x >= xs[0]; x--) {
            canvas.put(x, ys[1], pix);
        }

        for(int y = ys[1]-1; y >= ys[0]; y--) {
            canvas.put(xs[0], y, pix);
        }
    }
}
