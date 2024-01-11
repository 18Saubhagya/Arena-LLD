package models;

public class Player {
    private String playerName;
    private int playerId;
    private int playerHealth;
    private int playerStrength;
    private int playerAttack;

    public Player(String playerName, int playerId, int playerHealth, int playerStrength, int playerAttack) {
        this.playerName=playerName;
        this.playerId=playerId;
        this.playerHealth=playerHealth;
        this.playerStrength=playerStrength;
        this.playerAttack=playerAttack;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerHealth() {
        return this.playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerStrength() {
        return this.playerStrength;
    }

    public void setPlayerStrength(int playerStrength) {
        this.playerStrength = playerStrength;
    }

    public int getPlayerAttack() {
        return this.playerAttack;
    }

    public void setPlayerAttack(int playerAttack) {
        this.playerAttack = playerAttack;
    }
    
}
