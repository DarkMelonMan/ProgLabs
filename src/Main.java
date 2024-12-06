import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        do{
            System.out.println("Choose class type:\n1)MonsterEntity\n2)PlayerEntity\n3)Exit");
            do{
                Scanner in = new Scanner(System.in);
                DamageTest.choice = in.nextInt();
                if (DamageTest.choice < 1 || DamageTest.choice > 3)
                    System.out.print("Wrong choice. Try again: ");
            } while (DamageTest.choice < 1 || DamageTest.choice > 3);
            DamageTest.ChooseClass();
        } while (DamageTest.choice != 3);
    }
}
