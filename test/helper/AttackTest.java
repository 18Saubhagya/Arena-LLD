package test.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import helpers.Attack;

public class AttackTest {
    
    @Test
    public void testAttack() {
        assertEquals(100,Attack.calculateMoveValue(20, 5));
        assertEquals(30,Attack.calculateMoveValue(5, 6));
    }
}
