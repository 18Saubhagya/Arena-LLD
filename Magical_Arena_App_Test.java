import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import helpers.Attack;
import helpers.DamageCalculator;
import helpers.Defense;
import helpers.HealthCalculator;
import models.Dice;

public class Magical_Arena_App_Test {
    Dice dice=new Dice(1);

    @BeforeClass
    public static void initPlayers() {
        Magical_Arena_App.addPlayerToMap("AAA", 50, 5, 10);
        Magical_Arena_App.addPlayerToMap("BBB", 100, 10, 5);
    }

    @Test
    public void testInitializeAndStartGame() {
        String result=Magical_Arena_App.initializeAndStartGame(3, 4);
        assertEquals("Player A not registered", result);
        result=Magical_Arena_App.initializeAndStartGame(1, 4);
        assertEquals("Player B not registered", result);
        result=Magical_Arena_App.initializeAndStartGame(1, 2);
        assertEquals("Finished", result);
    }
    
    @Test
    public void testDice() {
        for(int i=0;i<100;i++) {
            int sum=dice.getDiceCount();
            assertTrue(sum>=1 && sum<=6);
        }
    }

    @Test
    public void testAttack() {
        assertEquals(100,Attack.calculateMoveValue(20, 5));
        assertEquals(30,Attack.calculateMoveValue(5, 6));
    }

    @Test
    public void testDefense() {
        assertEquals(100,Defense.calculateMoveValue(20, 5));
        assertEquals(30,Defense.calculateMoveValue(5, 6));
    }

    @Test
    public void testDamageCalculator() {
        assertEquals(50,DamageCalculator.calculateDamage(100, 50));
        assertEquals(0,DamageCalculator.calculateDamage(50, 100));
        assertEquals(0,DamageCalculator.calculateDamage(100, 100));
    }

    @Test
    public void testHealthCalculator() {
        assertEquals(50,HealthCalculator.calculateHealth(100, 50));
        assertEquals(0,HealthCalculator.calculateHealth(50, 100));
        assertEquals(0,HealthCalculator.calculateHealth(100, 100));
    }
}
