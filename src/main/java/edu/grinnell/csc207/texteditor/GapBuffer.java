package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer implements Buffer {
    private int size, cursor, endGap;
    private char[] buff;
    /**
     * Constructs an empty GapBuffer object of size 10.
     */
    public GapBuffer() {
        size = 10;
        cursor = 0;
        endGap = size;
        buff = new char[size];
    }
    
    /**
     * Doubles the size of the buffer, 
     * adding the new space between cursor and endgap.
     */
    public void expandBuffer() {
        char[] old = buff;
        buff = new char[size * 2];
        for(int i = 0; i<cursor; i++) {
            buff[i] = old[i];
        }
        for(int j = size - 1; j>=endGap; j--) {
            buff[j + size] = old[j];
        }
        endGap += size;
        size *= 2;
    }

    /**
     * Checks if buffer needs to be expanded and does so if so.
     * Adds ch to buffer and shifts cursor right.
     * @param ch character: to be added to buffer
     */
    public void insert(char ch) {
        if (cursor>=endGap) {
            this.expandBuffer();
        }
        buff[cursor] = ch;
        cursor++;
    }

    /**
     * Moves cursor to the left. endGap does not move.
     */
    public void delete() {
        if(cursor != 0) {
            cursor--;
        }
    }

    /**
     * @return integer: index of cursor
     */
    public int getCursorPosition() {
        return cursor;
    }

    /**
     * If cursor is not already at front of buffer, 
     * shifts entire gap left one character in the buffer
     */
    public void moveLeft() {
        if (cursor>0) {
            buff[--endGap] = buff[--cursor];
        }
    }
    
    /**
     * If endGap is not already at end of buffer,
     * shifts entire gap right one character in buffer
     */
    public void moveRight() {
        if (endGap<size) {
            buff[cursor++] = buff[endGap++];
        }
    }

    /**
     * @return int: number of chars in buffer (excludes gap)
     */
    public int getSize() {
        return size - (endGap - cursor);
    }

    /**
     * @param i integer: index in buffer
     * @return character at specified index (excludes gap)
     */
    public char getChar(int i) {
        if(i<cursor) {
            return buff[i];
        } else {
            return buff[i + endGap - cursor];
        }
    }

    /**
     * @return String of all characters in buffer (excludes gap)
     */
    public String toString() {
        String output = "";
        for(int i = 0; i<cursor; i++) {
            output += buff[i];
        }
        for (int i = endGap; i<size; i++) {
            output += buff[i];
        }
        return output;
    }
}
