import java.util.Scanner;

/**
 * Класс брони игроков
 */
public class Armor {
    private double baseDefence;
    private double elementDefence;
    private Element defenceType;

    public Armor(double baseDefence, double elementDefence, Element defenceType){
        this.baseDefence = baseDefence;
        this.elementDefence = elementDefence;
        this.defenceType = defenceType;
    }

    public Armor(){
        inputFields();
    }

    /**
     * Ввод всех полей объекта брони
     */
    private void inputFields(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a base defence of player armor: ");
        do {
            baseDefence = in.nextDouble();
            if (baseDefence <= 0)
                System.out.print("\nInvalid base defence. Try again: ");
        } while (baseDefence <= 0);
        int input;
        System.out.print("\nEnter elemental type of defence of player armor: ");
        do {
            input = in.nextInt();
            if (input < 0 || input > 3)
                System.out.print("\nInvalid type of defence. Try again: ");
            else defenceType = Element.values()[input];
        } while (input < 0 || input > 3);
        if (defenceType == Element.NONE) elementDefence = 0;
        else{
            do {
                elementDefence = in.nextDouble();
                if (elementDefence <= 0)
                    System.out.print("\nInvalid element defence. Try again: ");
            } while (elementDefence <= 0);
        }
        System.out.println();
    }

    /**
     * Получить общее количество урона
     * @param baseDamage - количество базового урона
     * @param elementDamage - количество стихийного урона
     * @param damageType - тип стихийного урона
     * @return общее количество урона с учётом базового и стихийного
     */
    public double GetActualDamage(double baseDamage, double elementDamage, Element damageType){
        double damage = baseDamage * (1 - baseDefence / 100);
        if (defenceType == damageType && damageType != Element.NONE)
            damage += elementDamage * (1 - elementDefence / 100);
        else if (damageType != Element.NONE) damage += elementDamage;
        return damage;
    }

    /**
     * Вывод всех полей брони в консоль
     */
    public void Print(){
        System.out.println("Player armor: ");
        System.out.println("Base defence: " + baseDefence);
        System.out.println("Elemental defence: " + elementDefence);
        System.out.println("Elemental type of defence: " + defenceType.toString());
    }
}
