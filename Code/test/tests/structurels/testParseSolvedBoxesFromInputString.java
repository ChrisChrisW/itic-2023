package tests.structurels;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import sudoku.Box;
import sudoku.Puzzle;

class testParseSolvedBoxesFromInputString {
    private Puzzle puzzle;

    @AfterEach
    void tearDown() {
    	puzzle = null;
    }
    
    @Test
    public void testInitialStateCaractereEtValide() {
        puzzle = new Puzzle("7");
		assertEquals(1, puzzle.getSolvedBoxes().size());
        assertEquals(7, puzzle.getSolvedValue(0,0));
    }

    @Test
    public void testInitialStateCaractereEtNonValide() {
        puzzle = new Puzzle("C");
        assertEquals(0, puzzle.getSolvedBoxes().size());
        assertEquals(new ArrayList<Box>(), puzzle.getSolvedBoxes());
    }
}