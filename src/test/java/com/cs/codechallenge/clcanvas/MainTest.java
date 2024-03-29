package com.cs.codechallenge.clcanvas;

import com.cs.codechallenge.clcanvas.commands.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by arnold on 20/8/17.
 */
public class MainTest {
    Console console;

    @Before
    public void before() {

    }

    @Test
    public void consoleTest() throws Exception {
        this.console = new Console(new Canvas());
        Assert.assertEquals(DrawCanvasCommand.class, console.parseCommand(new String[]{"C", "20", "40"}).getClass());
        Assert.assertEquals(DrawLineCommand.class, console.parseCommand(new String[]{"L", "0", "0", "0", "0"}).getClass());
        Assert.assertEquals(DrawRectangleCommand.class, console.parseCommand(new String[]{"R", "0", "0", "0", "0"}).getClass());
        Assert.assertEquals(FillAreaCommand.class, console.parseCommand(new String[]{"B", "0", "0", "x"}).getClass());
    }

    @Test
    public void drawCanvasTest() throws Exception {
        Canvas canvas = new Canvas();
        new DrawCanvasCommand(canvas, 20, 4, '-', '|').execute();

        // assert top border
        for (int col = 0; col < 22; col++ ) {
            Assert.assertEquals('-', canvas.getChar(col, 0));
        }

        // assert bottom border
        for (int col = 0; col < 22; col++ ) {
            Assert.assertEquals('-', canvas.getChar(col, 5));
        }

        // assert left border
        for (int row = 1; row < 5; row++ ) {
            Assert.assertEquals('|', canvas.getChar(0, row));
        }

        // draw right border
        for (int row = 1; row < 5; row++ ) {
            Assert.assertEquals('|', canvas.getChar(21, row));
        }
    }

    @Test
    public void drawLineTest() throws Exception {
        Canvas canvas = new Canvas();
        new DrawCanvasCommand(canvas, 20, 4, '-', '|').execute();

        new DrawLineCommand(canvas, 1, 2 , 6, 2, '*').execute();
        for(int i = 1; i <= 6; i++) {
            Assert.assertEquals('*', canvas.getChar(i, 2));
        }

        new DrawLineCommand(canvas, 6, 3 , 6, 4, '*').execute();
        Assert.assertEquals('*', canvas.getChar(6, 3));
        Assert.assertEquals('*', canvas.getChar(6, 4));
    }

    @Test
    public void drawRectangleTest() throws Exception {
        Canvas canvas = new Canvas();
        new DrawCanvasCommand(canvas, 20, 4, '-', '|').execute();

        new DrawRectangleCommand(canvas, 14, 1 , 18, 3, '*').execute();

        Assert.assertEquals('*', canvas.getChar(14, 1));
        Assert.assertEquals('*', canvas.getChar(15, 1));
        Assert.assertEquals('*', canvas.getChar(16, 1));
        Assert.assertEquals('*', canvas.getChar(17, 1));
        Assert.assertEquals('*', canvas.getChar(18, 1));

        Assert.assertEquals('*', canvas.getChar(18, 2));
        Assert.assertEquals('*', canvas.getChar(18, 3));

        Assert.assertEquals('*', canvas.getChar(17, 3));
        Assert.assertEquals('*', canvas.getChar(16, 3));
        Assert.assertEquals('*', canvas.getChar(15, 3));
        Assert.assertEquals('*', canvas.getChar(14, 3));

        Assert.assertEquals('*', canvas.getChar(14, 2));

    }

    @Test
    public void fillAreaTest() throws Exception {
        Canvas canvas = new Canvas();
        new DrawCanvasCommand(canvas, 20, 4, '-', '|').execute();
        new DrawLineCommand(canvas, 1, 2 , 6, 2, '*').execute();
        new DrawLineCommand(canvas, 6, 3 , 6, 4, '*').execute();
        new DrawRectangleCommand(canvas, 14, 1 , 18, 3, '*').execute();

        new FillAreaCommand(canvas, 10, 3 , 'o').execute();

        /*
        ----------------------
        |ooooooooooooo*****oo|
        |******ooooooo*   *oo|
        |     *ooooooo*****oo|
        |     *oooooooooooooo|
        ----------------------
        */

        Assert.assertEquals('o', canvas.getChar(1,1));
        Assert.assertEquals('o', canvas.getChar(13,1));

        Assert.assertEquals('o', canvas.getChar(7,4));

    }

    @After
    public void after() {

    }

}