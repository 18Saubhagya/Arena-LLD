package helpers;

public class HealthCalculator {

    public static int calculateHealth(int currentHealth, int damageValue) {
        if((currentHealth-damageValue)<0)
            return 0;
        return currentHealth-damageValue;
    }
}
