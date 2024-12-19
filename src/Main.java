import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        do{
            System.out.println("Choose class type:\n1)MonsterEntity\n2)PlayerEntity\n3)Matrix of objects\n4)Exit\n");
            do{
                Scanner in = new Scanner(System.in);
                DamageTest.choice = in.nextInt();
                if (DamageTest.choice < 1 || DamageTest.choice > 4)
                    System.out.print("Wrong choice. Try again: ");
            } while (DamageTest.choice < 1 || DamageTest.choice > 4);
            try {
                DamageTest.ChooseClass();
            }
            catch (TestError e){
                System.err.println(e.getMessage());
            }
        } while (DamageTest.choice != 4);
    }
}
