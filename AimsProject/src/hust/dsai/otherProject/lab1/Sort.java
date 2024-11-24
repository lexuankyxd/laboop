import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your array of integer, then enter a non numeric character to sort the array");
        Vector<Integer> v = new Vector<Integer>();
        while(sc.hasNextInt()){
            int tmp = sc.nextInt();
            v.addLast(tmp);
        }
        Collections.sort(v);
        System.out.println(v.toString());
    }
}
