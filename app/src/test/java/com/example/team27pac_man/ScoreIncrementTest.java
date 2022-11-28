package com.example.team27pac_man;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScoreIncrementTest {
    @Test
    public void checkScoreIncrement(){
        int score=10;
        int newScore=ScoreIncrement.scoreIncrement(score);
        assertEquals(11,newScore);
    }
    @Test
    public void ScoreIncrementWorkCheck(){
        int score=100;
        int newScore=ScoreIncrement.scoreIncrement(score);
        assertEquals(101,newScore);
    }
    @Test
    public void checkScoreIncrementNOT10(){
        int score=45;
        int newScore=ScoreIncrement.scoreIncrement(score);
        assertEquals(46,newScore);
    }
}
