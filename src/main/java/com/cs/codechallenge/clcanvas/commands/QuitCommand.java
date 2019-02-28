package com.cs.codechallenge.clcanvas.commands;

/**
 * Created by arnold on 20/8/17.
 */
public class QuitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}