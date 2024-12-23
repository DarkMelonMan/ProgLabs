import java.util.Scanner;

/**
 * Класс оружия игроков
 */
public class Weapon {
    private double baseDamage;
    private double elementDamage;
    private Util.Element damageType;

    public Weapon(double baseDamage, double elementDamage, Util.Element damageType){
        this.baseDamage = baseDamage;
        this.elementDamage = elementDamage;
        this.damageType = damageType;
    }

    public Weapon(){
        inputFields();
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public double getElementDamage() {
        return elementDamage;
    }

    public Util.Element getDamageType() {
        return damageType;
    }

    /**
     * Ввод всех полей объекта оружия
     */
    private void inputFields(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a base damage of player weapon: ");
        do {
            baseDamage = in.nextDouble();
            if (baseDamage <= 0)
                System.out.print("\nInvalid base damage. Try again: ");
        } while (baseDamage <= 0);
        int input;
        System.out.print("\nEnter elemental type of damage of player weapon: ");
        do {
            input = in.nextInt();
            if (input < 0 || input > 3)
                System.out.print("\nInvalid type of damage. Try again: ");
            else damageType = Util.Element.values()[input];
        } while (input < 0 || input > 3);
        if (damageType == Util.Element.NONE) elementDamage = 0;
        else{
            do {
                elementDamage = in.nextDouble();
                if (elementDamage <= 0)
                    System.out.print("\nInvalid element damage. Try again: ");
            } while (elementDamage <= 0);
        }
        System.out.println();
    }

    /**
     * Вывод всех полей объекта Weapon на экран
     */
    public void Print(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Player weapon:\nBase damage: " + baseDamage + "\nElemental damage: " + elementDamage +
                "\nElemental type of damage: " + damageType;
    }
}
