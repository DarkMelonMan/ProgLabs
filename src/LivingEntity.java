import java.util.Scanner;

/**
 * Класс живых существ, надкласс для классов игроков и монстров
 */
public class LivingEntity {
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
     * Получить урон
     * @param damage - количество урона
     */
    protected void hurt(double damage){
        healthPoints -= damage;
        if (healthPoints <= 0) {
            healthPoints = 0;
            System.out.println(name + " entity is dead!");
        }
    }
    /**
    * Ввод всех полей объекта живого существа
    */
    private void inputFields(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a name of a new entity: ");
        do {
            name = in.next();
            if (name.length() == 0)
                System.out.print("\nInvalid name. Try again: ");
        } while (name.length() == 0);
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
    public void Print(){
        System.out.println(name + " entity:");
        System.out.println("Health points: " + healthPoints);
        System.out.println("Movement speed: " + movementSpeed);
    }

    /**
     * Получить количество очков здоровья
     * @return количество очков здоровья
     */
    public double GetHealthPoints(){
        return healthPoints;
    }
}
