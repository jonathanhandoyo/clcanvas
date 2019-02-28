package com.cs.codechallenge.clcanvas.commands;

import com.cs.codechallenge.clcanvas.Canvas;

/**
 * Created by arnold on 20/8/17.
 */
public class FillAreaCommand implements Command {
    private Canvas canvas;
    private int x;
    private int y;
    private char c;

    public FillAreaCommand(Canvas canvas, int x, int y, char c) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public void execute() {
        char origin = canvas.getChar(x, y);
        canvas.put(x, y, c);
        spread(x-1, y, origin);
        spread(x+1, y, origin);
        spread(x, y-1, origin);
        spread(x, y+1, origin);
    }

    private void spread(int x, int y, char origin) {
        try {
            if(canvas.getChar(x, y) == origin) {
                canvas.put(x, y, c);
                spread(x-1, y, origin);
                spread(x+1, y, origin);
                spread(x, y-1, origin);
                spread(x, y+1, origin);
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
    }
}
