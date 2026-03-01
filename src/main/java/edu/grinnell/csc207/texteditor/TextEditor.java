package edu.grinnell.csc207.texteditor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.nio.file.*;

import com.googlecode.lanterna.TerminalPosition;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {
    /**
     * Prints contents of given buffer to given screen. 
     * Inserts a cursor character at the buffer's cursor position.
     * @param buf the GapBuffer to display
     * @param screen the Screen to display it on
     */
    public static void drawBuffer(GapBuffer buf, Screen screen) {
        screen.clear();
        int cursorPos = buf.getCursorPosition();
        
        for(int i = 0; i<cursorPos; i++) {
            screen.setCharacter(new TerminalPosition(i,0), 
                                TextCharacter.fromCharacter(buf.getChar(i))[0]);
        }
        screen.setCharacter(new TerminalPosition(cursorPos,0), 
                            TextCharacter.fromCharacter('|')[0]);
        for(int i = cursorPos; i<buf.getSize(); i++) {
            screen.setCharacter(new TerminalPosition(i + 1,0),
                                 TextCharacter.fromCharacter(buf.getChar(i))[0]);
        }

        try {
            screen.refresh();
        } catch(Exception e) {
            System.err.println(e);
        }
        
    }


    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) throws IOException { 
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        Screen screen = new DefaultTerminalFactory().createScreen();
        GapBuffer gap = new GapBuffer();

        String pathStr = args[0];
        System.out.format("Loading %s...\n", pathStr);
        Path path = Paths.get(pathStr);
        if (Files.exists(path) && Files.isRegularFile(path)) {
            String original = Files.readString(path);
            for(int i = 0; i<original.length(); i++) {
                gap.insert(original.charAt(i));
            }
        }
        System.out.println("Success!");
        
        screen.startScreen();
        boolean running = true;
        while (running) {
            KeyStroke stroke = screen.readInput();
            KeyType strokeType = stroke.getKeyType();
            if (strokeType == KeyType.Character) {
                gap.insert(stroke.getCharacter());
            } else if (strokeType == KeyType.ArrowLeft) {
                gap.moveLeft();
            } else if (strokeType == KeyType.ArrowRight) {
                gap.moveRight();
            } else if (strokeType == KeyType.Backspace) {
                gap.delete();
            } else if (strokeType == KeyType.Escape) {
                screen.stopScreen();
                running = false;
            }
            drawBuffer(gap, screen);
        }

        Files.writeString(path, gap.toString());
    }
}
