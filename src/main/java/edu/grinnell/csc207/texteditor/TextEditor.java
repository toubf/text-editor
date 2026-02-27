package edu.grinnell.csc207.texteditor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.TerminalPosition;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    public static void drawBuffer(GapBuffer buf, Screen screen){
        screen.clear();
        for(int i = 0; i < buf.getSize(); i++){
            screen.setCharacter(new TerminalPosition(i,0), TextCharacter.fromCharacter(buf.getChar(i))[0]);
        }

        try{
            screen.refresh();
        } catch(Exception e){
            System.err.println(e);
        }
        
    }


    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) { //throws IOException < instructions want this in our signature but its mad at us
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }



        try { 
            Screen screen = new DefaultTerminalFactory().createScreen();
            GapBuffer gap = new GapBuffer();
            boolean running = true;
            while (running){
                KeyStroke stroke = screen.readInput();
                KeyType strokeType = stroke.getKeyType();
                if (strokeType == KeyType.Character){
                    gap.insert(stroke.getCharacter());
                } else if (strokeType == KeyType.ArrowLeft){
                    gap.moveLeft();
                } else if (strokeType == KeyType.ArrowRight){
                    gap.moveRight();
                } else if (strokeType == KeyType.Backspace){
                    gap.delete();
                } else if (strokeType == KeyType.Escape){
                    screen.stopScreen();
                    running=false;
                }
                drawBuffer(gap, screen);
            }
            
        }catch(Exception e){
            System.err.println(e);
        }

        
        String path = args[0];
        System.out.format("Loading %s...\n", path);
    }
}
