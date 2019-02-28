package com.cs.codechallenge.clcanvas.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by arnold on 20/8/17.
 */
public class BufferedInputReader implements InputReader {

    public BufferedInputReader() {}

    @Override
    public String read(String prefix) throws Exception {
        System.out.print(prefix);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
