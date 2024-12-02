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
            MonsterEntity[] monsters = new MonsterEntity[2];
            monsters[0] = new MonsterEntity("Blob", 20, 1.5, 15, 8, Util.Element.MAGIC, Util.Element.FIRE);
            monsters[1] = new MonsterEntity("Ben", 20, 1.5, 15, 8, Util.Element.MAGIC, Util.Element.LIGHTING);
            PlayerEntity[] players = new PlayerEntity[2];
            players[0] = new PlayerEntity("Henry", 20, 1, new Armor(10, 35, Util.Element.FIRE), new Weapon(10, 10, Util.Element.FIRE));
            players[1] = new PlayerEntity("Henry", 25, 1, new Armor(10, 35, Util.Element.MAGIC), new Weapon(10, 10, Util.Element.MAGIC));
        switch (choice){
            case 1:
                System.out.println("Damage system test: monster attacks player:");
                monsters[0].AttackPlayer(players[0]);
                if (players[0].GetHealthPoints() + 0.00001 > 1.3 && players[0].GetHealthPoints() - 0.00001 < 1.3)
                    System.out.println("Test 1 was successful");
                else System.out.println("Current player health points = " + players[0].GetHealthPoints() +
                        " , but it must be 1,3. Test was unsuccessful");
                monsters[1].AttackPlayer(players[1]);
                if (players[1].GetHealthPoints() + 0.00001 > 3.5 && players[1].GetHealthPoints() - 0.00001 < 3.5)
                    System.out.println("Test 2 was successful");
                else System.out.println("Current player health points = " + players[1].GetHealthPoints() +
                        " , but it must be 3,5. Test was unsuccessful");
                break;
            case 2:
                System.out.println("Damage system test: player attacks monster:");
                players[0].AttackMonster(monsters[0]);
                if (monsters[0].GetHealthPoints() + 0.00001 > 5 && monsters[0].GetHealthPoints() - 0.00001 < 5)
                    System.out.println("Test 1 was successful");
                else System.out.println("Current monster health points = " + monsters[0].GetHealthPoints() +
                        " , but it must be 5. Test was unsuccessful");
                players[1].AttackMonster(monsters[1]);
                if (monsters[1].GetHealthPoints() + 0.00001 > 0 && monsters[1].GetHealthPoints() - 0.00001 < 0)
                    System.out.println("Test 2 was successful");
                else System.out.println("Current monster health points = " + monsters[1].GetHealthPoints() +
                        " , but it must be 0. Test was unsuccessful");
                break;
            default:
                break;
        }
        } while (choice != 3);
    }
}
