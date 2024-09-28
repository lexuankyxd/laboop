import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = console.nextLine();
        System.out.println("How old are you?");
        int age = console.nextInt();
        System.out.println("How tall are you?");
        double height = console.nextDouble();
        System.out.println("Mrs/Ms. " + name + ", " + age + " years old. Your height is " + height + ".");
    }
}
