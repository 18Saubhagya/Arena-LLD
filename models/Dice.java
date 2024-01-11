package models;

public class Dice {
    private int diceCount;

    public Dice() {
        diceCount=1;
    }
    public Dice(int count) {
        diceCount=count;
    }
    public int getDiceCount() {
        return diceCount;
    }
    public void setDiceCount(int count) {
        diceCount=count;
    }

    public int rollDice() {
        int sum=0,currentCount=diceCount;
        while(currentCount>0)
        {
            int diceNum=(int)Math.random()*6+1;
            sum+=diceNum;
            --currentCount;
        }
        return sum;
    }
}
