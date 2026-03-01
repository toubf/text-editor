package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer implements Buffer {
    private int size, cursor, endGap;
    private char[] buff;
    public GapBuffer() {
        size = 10;
        cursor = 0;
        endGap = size;
        buff = new char[size];
    }

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

    public void insert(char ch) {
        if (cursor>=endGap) {
            this.expandBuffer();
        }
        buff[cursor] = ch;
        cursor++;
    }

    public void delete() {
        if(cursor != 0) {
            cursor--;
        }
    }

    public int getCursorPosition() {
        return cursor;
    }

    public void moveLeft() {
        if (cursor>0) {
            buff[--endGap] = buff[--cursor];
        }
    }

    public void moveRight() {
        if (endGap<size) {
            buff[cursor++] = buff[endGap++];
        }
    }

    public int getSize() {
        return size - (endGap - cursor);
    }

    public char getChar(int i) {
        if(i<cursor) {
            return buff[i];
        } else {
            return buff[i + endGap - cursor];
        }
    }

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
