package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import main.Magical_Arena_App;

public class Magical_Arena_App_Test {

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
}
