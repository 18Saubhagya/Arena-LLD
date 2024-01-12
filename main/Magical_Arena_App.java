package main;


import java.util.HashMap;

import models.Magic_Arena_Game;
import models.Player;

public class Magical_Arena_App {

    private static HashMap<Integer,Player> players = new HashMap<>();
    private static int counterId=1;

    public static String initializeAndStartGame(int playerA_Id, int playerB_Id) {
        if(!players.containsKey(playerA_Id)) {
            System.out.println("Player A hasn't registered yet!");
            return "Player A not registered";
        }
        if(!players.containsKey(playerB_Id)) {
            System.out.println("Player B hasn't registered yet!");
            return "Player B not registered";
        }

        Magic_Arena_Game newGame = new Magic_Arena_Game();
        newGame.setPlayers(players.get(playerA_Id), players.get(playerB_Id));
        newGame.setDice(1);
        newGame.startGame();
        return "Finished";
    } 

    public static void addPlayerToMap(String name, int health, int stregnth, int attack) {
        Player player = new Player(name, counterId, health, stregnth, attack);
        players.put(counterId,player);
        counterId++;
    }
    public static void main(String[] args) {
        addPlayerToMap("AAA", 50, 5, 10);
        addPlayerToMap("BBB", 100, 10, 5);
        // Can keep on adding players likewise

        initializeAndStartGame(1, 2);
    }
}