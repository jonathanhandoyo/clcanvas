package com.cs.codechallenge.clcanvas.reader;

import java.io.Console;

/**
 * Created by arnold on 20/8/17.
 */
public class ConsoleInputReader implements InputReader {
    Console console;

    public ConsoleInputReader(Console console){
        this.console = console;
    }


    @Override
    public String read(String prefix) {
        System.out.print(prefix);
        return System.console().readLine();
    }
}
