package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;


public class GapBufferTests {
    @Test
    public void emtpyBuffTest(){
        GapBuffer buffer = new GapBuffer();
        assertEquals(0,buffer.getSize());
        assertEquals(0, buffer.getCursorPosition());
    }

    @Test 
    public void basicBuffTest(){
        GapBuffer buffer = new GapBuffer();
        buffer.insert(' ');
        assertEquals(1, buffer.getSize());
        assertEquals(1, buffer.getCursorPosition());
        assertEquals(' ', buffer.getChar(0));
        assertEquals(" ", buffer.toString());
        buffer.delete();
        assertEquals(0,buffer.getSize());
        assertEquals(0, buffer.getCursorPosition());
    }

    @Test
    public void longerBuffTest(){
        GapBuffer buffer = new GapBuffer();
        for(int i=0; i < 10; i++){
            buffer.insert(Integer.toString(i).charAt(0));
        }
        assertEquals(buffer.getSize(), buffer.getCursorPosition());
        assertEquals('0', buffer.getChar(0));
        buffer.moveRight();
        assertEquals(buffer.getSize(), buffer.getCursorPosition());

        for(int i=9; i >=0; i--){
            buffer.moveLeft();
            assertEquals(i, buffer.getCursorPosition());
        }
        buffer.moveLeft();
        assertEquals(0, buffer.getCursorPosition());
        buffer.delete();
        assertEquals(0, buffer.getCursorPosition());
        assertEquals(10, buffer.getSize());
        assertEquals("0123456789", buffer.toString());

        for(int i=0; i < 5; i++){
            assertEquals(i, buffer.getCursorPosition());
            buffer.moveRight();
            
        }
        buffer.delete();
        assertEquals(9, buffer.getSize());
        assertEquals("012356789", buffer.toString());
        buffer.insert('p');
        assertEquals("0123p56789", buffer.toString());
        assertEquals(10, buffer.getSize());
        assertEquals(5, buffer.getCursorPosition());
    }

    @Test
    public void longestBuffTest(){
        GapBuffer buffer = new GapBuffer();
        for(int i=0; i < 10; i++){
            buffer.insert(Integer.toString(i).charAt(0));
        }
        buffer.insert('0'); //inserts after buffer expansion
        assertEquals(buffer.getSize(), buffer.getCursorPosition());
        assertEquals('0', buffer.getChar(0));
        buffer.moveRight();
        assertEquals(buffer.getSize(), buffer.getCursorPosition());

        for(int i=10; i >=0; i--){
            buffer.moveLeft();
            assertEquals(i, buffer.getCursorPosition());
        }
        buffer.moveLeft();
        assertEquals(0, buffer.getCursorPosition());
        buffer.delete();
        assertEquals(0, buffer.getCursorPosition());
        assertEquals(11, buffer.getSize());
        assertEquals("01234567890", buffer.toString());

        for(int i=0; i < 5; i++){
            assertEquals(i, buffer.getCursorPosition());
            buffer.moveRight();
        }

        buffer.delete();
        assertEquals(10, buffer.getSize());
        assertEquals("0123567890", buffer.toString());
        buffer.insert('p');
        assertEquals("0123p567890", buffer.toString());
        assertEquals(11, buffer.getSize());
        assertEquals(5, buffer.getCursorPosition());
    }

    @Property
    public boolean buffTest(@ForAll @IntRange(min=0, max=100) int n){
        GapBuffer buffer = new GapBuffer();
        for (int i = 0; i < n; i++){
            buffer.insert('p');
            buffer.insert('u');
        }
        return ((buffer.getSize() == 2*n) && (buffer.getCursorPosition() == 2*n));
    }
}