package test.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.Dice;

public class BoardTest {
    Dice dice=new Dice(1);

    @Test
    public void testRollDice() {
        
        for(int i=0;i<100;i++) {
            int sum=dice.getDiceCount();
            assertTrue(sum>=1 && sum<=6);
        }
    }
}
