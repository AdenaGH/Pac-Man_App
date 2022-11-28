package com.example.team27pac_man;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CellTest {@Test
public void checkvisited(){
    Cell cell=new Cell(3,4);
    assertFalse(cell.visited);
}
@Test
public void checkleftWall(){
    Cell cell=new Cell(3,4);
    assertFalse(cell.leftWall);
}

@Test
    public void checkrightWall(){
        Cell cell=new Cell(3,4);
        assertFalse(cell.rightWall);
    }

    @Test
    public void checktopWall(){
        Cell cell=new Cell(3,4);
        assertFalse(cell.topWall);
    }

    @Test
    public void checkbottomWall(){
        Cell cell=new Cell(3,4);
        assertFalse(cell.bottomWall);
    }
}
