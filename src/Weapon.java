import java.util.Scanner;

/**
 * Класс оружия игроков
 */
public class Weapon {
    private double baseDamage;
    private double elementDamage;
    private Element damageType;

    public Weapon(double baseDamage, double elementDamage, Element damageType){
        this.baseDamage = baseDamage;
        this.elementDamage = elementDamage;
        this.damageType = damageType;
    }

    public Weapon(){
        inputFields();
    }

    /**
     * Получить общее количество урона, наносимое монстру
     * @param weakness - Тип элементальной слабости монстра
     * @return Общее количество урона с учётом стихийного и физического урона
     */
    public double GetDamage(Element weakness){
        double damage = baseDamage;
        if (weakness == damageType && weakness != Element.NONE)
            damage += elementDamage;
        else if (weakness != Element.NONE)
            damage += elementDamage * 0.5;
        return damage;
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
            else damageType = Element.values()[input];
        } while (input < 0 || input > 3);
        if (damageType == Element.NONE) elementDamage = 0;
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
        System.out.println("Player weapon: ");
        System.out.println("Base damage: " + baseDamage);
        System.out.println("Elemental damage: " + elementDamage);
        System.out.println("Elemental type of damage: " + damageType.toString());
    }
}
