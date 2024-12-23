import java.util.Scanner;

/**
 * Класс живых существ, надкласс для классов игроков и монстров
 */
public class LivingEntity extends Entity{
    protected String name;
    protected double healthPoints;
    protected double movementSpeed;

    public LivingEntity(String name, double healthPoints, double movementSpeed){
        this.name = name;
        this.healthPoints = healthPoints;
        this.movementSpeed = movementSpeed;
    }

    public LivingEntity(){
        inputFields();
    }

    /**
    * Ввод всех полей объекта живого существа
    */
    @Override
    protected void inputFields(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a name of a new entity: ");
        do {
            name = in.next();
            if (name.isEmpty())
                System.out.print("\nInvalid name. Try again: ");
        } while (name.isEmpty());
        System.out.print("\nEnter health points of " + name + " entity: ");
        do {
            healthPoints = in.nextDouble();
            if (healthPoints <= 0)
                System.out.print("\nInvalid health points. Try again: ");
        } while (healthPoints <= 0);
        System.out.print("\nEnter movement speed of " + name + " entity: ");
        do {
            movementSpeed = in.nextDouble();
            if (movementSpeed <= 0)
                System.out.print("\nInvalid movement speed. Try again: ");
        } while (movementSpeed <= 0);
        System.out.println();
    }

    /**
     * Вывод на экран всех полей объекта LivingEntity
     */
    @Override
    public void Print(){
        System.out.println(this);
    }



    @Override
    public String toString(){
        return name + " entity:" + "\nHealth points: " + healthPoints + "\nMovement speed: " + movementSpeed;
    }
}
