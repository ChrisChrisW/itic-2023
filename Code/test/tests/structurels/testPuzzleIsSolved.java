package tests.structurels;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;

import sudoku.Puzzle;

public class testPuzzleIsSolved {
    private Puzzle puzzle;
    
    @AfterEach
    void tearDown() {
    	puzzle = null;
    }

    @Test
    public void testIsNotSolved00IncompletePuzzle() {
    	puzzle = new Puzzle(".23456789" + "456789123" + "........." +
			                "214365897" + "........." + "&é$à(§è!ç" +
			                "........." + "AbcdEfghI" + "978531642");

        assertEquals(puzzle.dimension(), puzzle.getPossibleValues(0, 0).length);
        assertFalse(puzzle.isSolved());
    }
    
    @Test
    public void testIsNotSolved01IncompletePuzzle() {
    	puzzle = new Puzzle("1." + "21");
        assertEquals(puzzle.dimension(), puzzle.getPossibleValues(0, 1).length);
        assertFalse(puzzle.isSolved());
    }
    
    @Test
    public void testIsNotSolved10IncompletePuzzle() {
    	puzzle = new Puzzle("11" + ".1");
        assertEquals(puzzle.dimension(), puzzle.getPossibleValues(1, 0).length);
        assertFalse(puzzle.isSolved());
    }
    
    @Test
    public void testIsNotSolved11IncompletePuzzle() {
    	puzzle = new Puzzle("12" + "2G");
        assertEquals(puzzle.dimension(), puzzle.getPossibleValues(1, 1).length);
        assertFalse(puzzle.isSolved());
    }
    
    @Test
    public void testIsSolvedPuzzle() {
    	puzzle = new Puzzle("11" + "11");
       
    	// Dans notre test, on ne teste pas les valeurs uniques dans le puzzle mais une méthode existe dans Puzzle qu'on ne teste pas ici
        assertEquals(0, puzzle.getUnsolvedBoxes().size());
        assertTrue(puzzle.isSolved());
    }
}