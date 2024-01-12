package test.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import helpers.HealthCalculator;

public class TestHealthCalculator {
    
    @Test
    public void testHealthCalculator() {
        assertEquals(50,HealthCalculator.calculateHealth(100, 50));
        assertEquals(0,HealthCalculator.calculateHealth(50, 100));
        assertEquals(0,HealthCalculator.calculateHealth(100, 100));
    }
}
