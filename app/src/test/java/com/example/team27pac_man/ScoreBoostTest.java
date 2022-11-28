package com.example.team27pac_man;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScoreBoostTest {
    @Test
    public void checkScoreBoost(){
        int score=10;
        int newScore=ScoreBoost.scoreBoost(score);
        assertEquals(20,newScore);
    }
    @Test
    public void ScoreBoostWorkCheck(){
        int score=100;
        int newScore=ScoreBoost.scoreBoost(score);
        assertEquals(110,newScore);
    }
    @Test
    public void checkScoreBoostNOT10(){
        int score=45;
        int newScore=ScoreBoost.scoreBoost(score);
        assertEquals(55,newScore);
    }
}
