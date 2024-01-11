package models;

public class DamageCalculator {
    
    public int calculateMoveValue(int value, int diceValue) {
        return value*diceValue;
    }

    public int calculateDamage(int attackValue, int defenseValue) {
        return attackValue-defenseValue;
    }

    public int calculateHealth(int currentHealth, int damageValue) {
        return currentHealth-damageValue;
    }
}
