package models;

import helpers.Attack;
import helpers.DamageCalculator;
import helpers.Defense;
import helpers.HealthCalculator;

public class Magic_Arena_Game {
    private Player playerA, playerB;
    private Dice dice;

    public void setPlayers(Player playerA, Player playerB) {
        this.playerA=playerA;
        this.playerB=playerB;
    }

    public void setDice(int diceCount) {
        dice = new Dice(diceCount);
    }

    private void displayWinner(Player winner, Player loser) {
        System.out.println("Match Ended");
        System.out.println("Winner of the Game is: "+winner.getPlayerName());
        System.out.println("Better luck next time: "+loser.getPlayerName());
    }

    private int calculateTurn(Player attackPlayer, Player defensepPlayer) {
        int diceValue=dice.rollDice();
        System.out.println("Dice Rolled for attack: "+diceValue);
        int attackValue=Attack.calculateMoveValue(attackPlayer.getPlayerAttack(), diceValue);

        diceValue=dice.rollDice();
        System.out.println("Dice Rolled for defense: "+diceValue);
        int defenseValue=Defense.calculateMoveValue(defensepPlayer.getPlayerStrength(), diceValue);

        int damageValue=DamageCalculator.calculateDamage(attackValue, defenseValue);
        return damageValue;
    }

    public void startGame() {
        System.out.println("Game is getting started!!");
        System.out.println();

        int turn=0; // 0 represents player A's chance while 1 represents player B's turn 
        if(playerA.getPlayerHealth() > playerB.getPlayerHealth())
            turn=1;

        int maxMove=1000;
        while(maxMove>0)
        {
            //Player A turn
            if(turn==0)
            {
                System.out.println(playerA.getPlayerName()+" Turn!");
                int damageValue=calculateTurn(playerA, playerB);
                playerB.setPlayerHealth(HealthCalculator.calculateHealth(playerB.getPlayerHealth(),damageValue)); //Updating the health of B after defense
            }
            //Player B turn
            else
            {
                System.out.println(playerB.getPlayerName()+" Turn!");
                int damageValue=calculateTurn(playerB, playerA);
                playerA.setPlayerHealth(HealthCalculator.calculateHealth(playerA.getPlayerHealth(),damageValue)); //Updating the health of A after defense
            }

            System.out.println(playerA.getPlayerName() + " health after this turn: "+ playerA.getPlayerHealth());
            System.out.println(playerB.getPlayerName() + " health after this turn: "+ playerB.getPlayerHealth());
            System.out.println();

            //Checking if any player's health has reached 0
            if(playerA.getPlayerHealth()==0) {
                displayWinner(playerB,playerA);
                return;
            }
            if(playerB.getPlayerHealth()==0) {
                displayWinner(playerA,playerB);
                return;
            }
            turn=1-turn;
            --maxMove;
        }
        System.out.println("No result after number of allowed moves");
    }
}
