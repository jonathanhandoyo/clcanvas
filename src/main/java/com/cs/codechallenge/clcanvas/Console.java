package com.cs.codechallenge.clcanvas;

import com.cs.codechallenge.clcanvas.commands.*;
import com.cs.codechallenge.clcanvas.reader.BufferedInputReader;
import com.cs.codechallenge.clcanvas.reader.ConsoleInputReader;
import com.cs.codechallenge.clcanvas.reader.InputReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnold on 20/8/17.
 */
public class Console {
    private static final String COMMAND_PREFIX = "enter command: ";
    private static final String COMMAND_SPLITTER = " ";

    private static final char BORDER_HORIZONTAL = '-';
    private static final char BORDER_VERTICAL = '|';
    private static final char PIX_CHAR = '*';

    private Canvas canvas;

    private List<Command> commands = new ArrayList<>();
    private InputReader inputReader;

    public Console(Canvas canvas){
        this.canvas = canvas;

        java.io.Console console = System.console();
        this.inputReader = console != null ? new ConsoleInputReader(console) : new BufferedInputReader();
    }

    public void read() throws Exception {
        this.commands.add(
            this.parseCommand(
                this.inputReader.read(COMMAND_PREFIX)
                        .split(COMMAND_SPLITTER)
            )
        );
    }

    public Command parseCommand(String[] commandParts) throws IllegalArgumentException {

        Command command;
        switch (commandParts[0]) {
            case "C": command = new DrawCanvasCommand(canvas,
                    Integer.valueOf(commandParts[1]),
                    Integer.valueOf(commandParts[2]),
                    BORDER_HORIZONTAL,
                    BORDER_VERTICAL); break;

            case "L": command = new DrawLineCommand(canvas,
                    Integer.valueOf(commandParts[1]),
                    Integer.valueOf(commandParts[2]),
                    Integer.valueOf(commandParts[3]),
                    Integer.valueOf(commandParts[4]),
                    PIX_CHAR); break;

            case "R": command = new DrawRectangleCommand(canvas,
                    Integer.valueOf(commandParts[1]),
                    Integer.valueOf(commandParts[2]),
                    Integer.valueOf(commandParts[3]),
                    Integer.valueOf(commandParts[4]),
                    PIX_CHAR); break;

            case "B": command = new FillAreaCommand(canvas,
                    Integer.valueOf(commandParts[1]),
                    Integer.valueOf(commandParts[2]),
                    commandParts[3].charAt(0)); break;

            case "Q": command = new QuitCommand(); break;

            default: throw new IllegalArgumentException("Unrecognized command");
        }

        return command;
    }

    public void execute() {
        for (Command command: this.commands) {
            command.execute();
        }

        canvas.draw();
    }

}