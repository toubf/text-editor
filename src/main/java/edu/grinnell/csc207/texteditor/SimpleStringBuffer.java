package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer implements Buffer {
    private String buff;
    private int cursor;

    /**
     * Constructs a SimpleStringBuffer object with an empty String buff and a 
     * cursor = 0
     */
    public SimpleStringBuffer(){
        buff = "";
        cursor = 0;

    }

    public void insert(char ch) {
        String old = buff;
        buff = old.substring(0,cursor);
        buff += ch;
        buff += old.substring(cursor);
        cursor++;
    }

    public void delete() {
        if (cursor != 0){
            String old = buff;
            buff = old.substring(0, --cursor);
            buff += old.substring(cursor +1);
        }
    }

    /**
     * @return int: position of cursor
     */
    public int getCursorPosition() {
        return cursor;
    }

    public void moveLeft() {
        if (cursor != 0){
          cursor--;
        }
    }

    public void moveRight() {
        if (cursor != this.getSize()){
            cursor++;
          }
    }

    /**
     * @return integer: length of buffer
     */
    public int getSize() {
        return buff.length();
    }

    public char getChar(int i) {
        return buff.charAt(i);
    }

    @Override
    public String toString() {
        return buff;
    }
}
