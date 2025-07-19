package com.aurionpro.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CellTest {

	@Test
	public void testCellIsEmptyAfterCreation() {
	    Cell cell = new Cell();           
	    assertTrue(cell.isEmpty());       
	}

	@Test
	public void testCellCanBeMarked() {
	    Cell cell = new Cell();
	    cell.mark("X");                          
	    assertEquals("X", cell.getValue());     
	}
	
	@Test
	public void testCellCannotBeMarkedTwice() {
	    Cell cell = new Cell();
	    cell.mark("O");      
	    Exception e = assertThrows(IllegalStateException.class, () -> {
	        cell.mark("X");
	    });
	    assertEquals("Cell already marked", e.getMessage());
	}
}
