import java.util.Scanner;

/**
 * Класс монстров - противников игрока
 */
public class MonsterEntity extends LivingEntity {
    double baseDamage;
    double elementDamage;
    Element weakness;
    Element damageType;

    public MonsterEntity(String name, double healthPoints, double movementSpeed, double baseDamage
            , double elementDamage, Element weakness, Element damageType){
        super(name, healthPoints, movementSpeed);
        this.baseDamage = baseDamage;
        this.elementDamage = elementDamage;
        this.weakness = weakness;
        this.damageType = damageType;
    }

    public MonsterEntity(){
        super();
        inputFields();
    }
    /**
     * Ввод всех полей объекта монстра
     */
    void inputFields(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a base damage of " + name + " monster entity: ");
        do {
            baseDamage = in.nextDouble();
            if (baseDamage <= 0)
                System.out.print("\nInvalid base damage. Try again: ");
        } while (baseDamage <= 0);
        System.out.print("\nEnter elemental type of weakness of " + name + " monster entity (0 - none, 1 - fire, 2 - magic, 3 - lighting): ");
        int input;
        do {
            input = in.nextInt();
            if (input < 0 || input > 3)
                System.out.print("\nInvalid weakness type. Try again: ");
            else weakness = Element.values()[input];
        } while (input < 0 || input > 3);
        System.out.print("\nEnter elemental type of damage of " + name + " monster entity: ");
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
     * Получить урон
     * @param damage - Общее количество урона
     */
    public void Hurt(double damage){
        hurt(damage);
    }

    public void AttackPlayer(PlayerEntity player){
        player.Hurt(baseDamage, elementDamage, damageType);
    }

    /**
     * Вывод на экран всех полей объекта MonsterEntity
     */
    public void Print(){
        super.Print();
        System.out.println("Base damage: " + baseDamage);
        System.out.println("Elemental damage: " + elementDamage);
        System.out.println("Elemental weakness type: " + weakness.toString());
        System.out.println("Elemental type of damage: " + damageType.toString());
    }

    /**
     * Получить слабость монстра к определённому типу стихийного урона
     * @return Слабость к определённому типу стихийного урона
     */
    public Element GetMonsterWeakness(){
        return weakness;
    }
}
