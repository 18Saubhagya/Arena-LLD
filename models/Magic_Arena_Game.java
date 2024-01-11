package models;

public class Magic_Arena_Game {
    private Player playerA, playerB;
    private Dice dice;
    private DamageCalculator damage;

    public void setPlayers(Player playerA, Player playerB) {
        this.playerA=playerA;
        this.playerB=playerB;
    }

    public void setDice(int diceCount) {
        dice = new Dice(diceCount);
    }

    public void setDamage() {
        damage = new DamageCalculator();
    }

    private void displayWinner(Player winner, Player loser) {
        System.out.println("Match Ended");
        System.out.println("Winner of the Game is: "+winner.getPlayerName());
        System.out.println("Better luck next time: "+loser.getPlayerName());
    }

    private int calculateTurn(Player attackPlayer, Player defensepPlayer) {
        int diceValue=dice.rollDice();
        System.out.println("Dice Rolled for attack: "+diceValue);
        int attackValue=damage.calculateMoveValue(attackPlayer.getPlayerAttack(), diceValue);

        diceValue=dice.rollDice();
        System.out.println("Dice Rolled for defense: "+diceValue);
        int defenseValue=damage.calculateMoveValue(defensepPlayer.getPlayerStrength(), diceValue);

        int damageValue=damage.calculateDamage(attackValue, defenseValue);
        return damageValue;
    }

    public void startGame() {
        System.out.println("Game is getting started!!");
        System.out.println();

        if(playerA.getPlayerHealth()==0 && playerB.getPlayerHealth()==0) {
            System.out.println("Both players have 0 Health Points");
            return;
        }

        //If both players have 0 Attack attribute, game will not end forever
        if(playerA.getPlayerAttack()==0 && playerB.getPlayerAttack()==0) {
            System.out.println("Both players have 0 Attack Points");
            return;
        }

        int turn=0; // 0 represents player A's chance while 1 represents player B's turn 
        if(playerA.getPlayerHealth() > playerB.getPlayerHealth())
            turn=1;

        while(true)
        {
            //Player A turn
            if(turn==0)
            {
                System.out.println(playerA.getPlayerName()+" Turn!");
                int damageValue=calculateTurn(playerA, playerB);
                playerB.setPlayerHealth(damage.calculateHealth(playerB.getPlayerHealth(),damageValue)); //Updating the health of B after defense
            }
            //Player B turn
            else
            {
                System.out.println(playerB.getPlayerName()+" Turn!");
                int damageValue=calculateTurn(playerB, playerA);
                playerA.setPlayerHealth(damage.calculateHealth(playerA.getPlayerHealth(),damageValue)); //Updating the health of A after defense
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
        }
    }
}
