import java.util.Scanner;

/**
 * Класс для тестирования работы системы урона
 */
public class DamageTest {
    /**
     * Выбор класса для тестирования
     */
    static void ChooseClass(){
        int choice;
        do{
            System.out.println("Choose class type:\n1)MonsterEntity\n2)PlayerEntity\n3)Exit");
            do{
                Scanner in = new Scanner(System.in);
                choice = in.nextInt();
                if (choice < 1 || choice > 3)
                    System.out.print("Wrong choice. Try again: ");
            } while (choice < 1 || choice > 3);
            MonsterEntity monster1 = new MonsterEntity("Blob", 20, 1.5, 15, 8, Element.MAGIC, Element.FIRE);
            MonsterEntity monster2 = new MonsterEntity("Ben", 20, 1.5, 15, 8, Element.MAGIC, Element.LIGHTING);
            PlayerEntity player1 = new PlayerEntity("Henry", 20, 1, new Armor(10, 35, Element.FIRE), new Weapon(10, 10, Element.FIRE));
            PlayerEntity player2 = new PlayerEntity("Henry", 25, 1, new Armor(10, 35, Element.MAGIC), new Weapon(10, 10, Element.MAGIC));
        switch (choice){
            case 1:
                System.out.println("Damage system test: monster attacks player:");
                monster1.AttackPlayer(player1);
                if (player1.GetHealthPoints() + 0.00001 > 1.3 && player1.GetHealthPoints() - 0.00001 < 1.3)
                    System.out.println("Test 1 was successful");
                else System.out.println("Current player health points = " + player1.GetHealthPoints() +
                        " , but it must be 1,3. Test was unsuccessful");
                monster2.AttackPlayer(player2);
                if (player2.GetHealthPoints() + 0.00001 > 3.5 && player2.GetHealthPoints() - 0.00001 < 3.5)
                    System.out.println("Test 2 was successful");
                else System.out.println("Current player health points = " + player2.GetHealthPoints() +
                        " , but it must be 3,5. Test was unsuccessful");
                break;
            case 2:
                System.out.println("Damage system test: player attacks monster:");
                player1.AttackMonster(monster1);
                if (monster1.GetHealthPoints() + 0.00001 > 5 && monster1.GetHealthPoints() - 0.00001 < 5)
                    System.out.println("Test 1 was successful");
                else System.out.println("Current monster health points = " + monster1.GetHealthPoints() +
                        " , but it must be 5. Test was unsuccessful");
                player2.AttackMonster(monster2);
                if (monster2.GetHealthPoints() + 0.00001 > 0 && monster2.GetHealthPoints() - 0.00001 < 0)
                    System.out.println("Test 2 was successful");
                else System.out.println("Current monster health points = " + monster2.GetHealthPoints() +
                        " , but it must be 0. Test was unsuccessful");
                break;
            default:
                break;
        }
        } while (choice != 3);
    }
}
