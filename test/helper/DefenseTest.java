package test.helper;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import helpers.Defense;
public class DefenseTest {
    
    @Test
    public void testDefense() {
        assertEquals(100,Defense.calculateMoveValue(20, 5));
        assertEquals(30,Defense.calculateMoveValue(5, 6));
    }
}
