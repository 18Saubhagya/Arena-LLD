package helpers;

public class DamageCalculator {

    public static int calculateDamage(int attackValue, int defenseValue) {
        if((attackValue-defenseValue)<0)
            return 0;
        return attackValue-defenseValue;
    }
}
