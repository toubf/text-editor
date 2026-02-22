package edu.grinnell.csc207.texteditor;

/**
 * A buffer captures the backing data structure for our text editor.
 */
public interface Buffer {
    /** Inserts a character at the index of the cursor
     * 
     * @param ch character given by user to be inserted
     */
    public void insert(char ch);

    /** Removes character preceeding the index of the cursor 
     */
    public void delete();

    /** 
     * @return index of cursor as integer
     */
    public int getCursorPosition();

    /**
     * Decreases index of cursor by 1
     */
    public void moveLeft();

    /**
     * Increases index of cursor by 1
     */
    public void moveRight();

    /**
     * @return size of buffer as integer
     */
    public int getSize();

    /**
     * @param i integer, represents an index in buffer
     * @return character at given index in buffer
     */
    public char getChar(int i);

    /**
     * @return String the entire contents of buffer
     */
    public String toString();
}
