package models;

public class DamageCalculator {
    
    public int calculateMoveValue(int value, int diceValue) {
        return value*diceValue;
    }

    public int calculateDamage(int attackValue, int defenseValue) {
        if((attackValue-defenseValue)<0)
            return 0;
        return attackValue-defenseValue;
    }

    public int calculateHealth(int currentHealth, int damageValue) {
        if((currentHealth-damageValue)<0)
            return 0;
        return currentHealth-damageValue;
    }
}
