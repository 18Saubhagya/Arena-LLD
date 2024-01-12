package test.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import helpers.DamageCalculator;

public class TestDamageCalculator {
    
    @Test
    public void testDamageCalculator() {
        assertEquals(50,DamageCalculator.calculateDamage(100, 50));
        assertEquals(0,DamageCalculator.calculateDamage(50, 100));
        assertEquals(0,DamageCalculator.calculateDamage(100, 100));
    }
}
