/**
 * Класс для тестирования работы системы урона
 */
public class DamageTest {
    static int choice;

    /**
     * Выбор класса для тестирования
     */
    static void ChooseClass() throws TestError{
            MonsterEntity[] monsters = new MonsterEntity[2];
            monsters[0] = new MonsterEntity("Blob", 20, 1.5, 15, 8, Util.Element.MAGIC, Util.Element.FIRE);
            monsters[1] = new MonsterEntity("Ben", 20, 1.5, 15, 8, Util.Element.MAGIC, Util.Element.LIGHTING);
            PlayerEntity[] players = new PlayerEntity[2];
            players[0] = new PlayerEntity("Henry", 20, 1,
                    new Armor(10, 35, Util.Element.FIRE), new Weapon(10, 10, Util.Element.FIRE));
            players[1] = new PlayerEntity("Henry", 25, 1,
                    new Armor(10, 35, Util.Element.MAGIC), new Weapon(10, 10, Util.Element.MAGIC));
            LivingEntity[][] entities = {monsters, players};
            Armor armor1 = new Armor(10, 10, Util.Element.FIRE);
            Armor armor2 = new Armor(50, 50, Util.Element.MAGIC);
        switch (choice) {
            case 1:
                System.out.println("Damage system test: monster attacks player:");
                monsters[0].Attack(players[0]);
                if (players[0].GetHealthPoints() + 0.00001 > 1.3 && players[0].GetHealthPoints() - 0.00001 < 1.3)
                    System.out.println("Test 1 was successful");
                else throw new TestError(players[0].GetHealthPoints(), 1.3, "player health points");
                monsters[1].Attack(players[1]);
                if (players[1].GetHealthPoints() + 0.00001 > 3.5 && players[1].GetHealthPoints() - 0.00001 < 3.5)
                    System.out.println("Test 2 was successful");
                else
                    throw new TestError(players[1].GetHealthPoints(), 3.5, "player health points");
                break;
            case 2:
                System.out.println("Damage system test: player attacks monster:");
                players[0].Attack(monsters[0]);
                if (monsters[0].GetHealthPoints() + 0.00001 > 5 && monsters[0].GetHealthPoints() - 0.00001 < 5)
                    System.out.println("Test 1 was successful");
                else throw new TestError(monsters[0].GetHealthPoints(), 5, "monster health points");
                players[1].Attack(monsters[1]);
                if (monsters[1].GetHealthPoints() + 0.00001 > 0 && monsters[1].GetHealthPoints() - 0.00001 < 0)
                    System.out.println("Test 2 was successful");
                else throw new TestError(monsters[1].GetHealthPoints(), 0, "monster health points");
                break;
            case 3:
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++)
                        entities[i][j].Print();
                break;
            case 4:
                armor1 = armor2.clone();
                armor1.Print();
                armor1 = armor2.deepClone();
                armor1.Print();
            default:
                break;
        }
    }
}
