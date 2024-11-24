import java.util.Scanner;

public class DaysLookUp {
    static String[] ms = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec.",
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Year: ");
        int year = sc.nextInt();
        while(year < 0){
            System.out.println("Year must be positive, enter again: ");
            year = sc.nextInt();
        }
        System.out.println("Month: ");
        String month = sc.next();
        int days = 0;
        boolean b = true;
        while(true){
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 4; j++){
                    if(ms[j * 12 + i].equals(month)){
                        month = ms[3 * 12 + i];
                        b = false;
                        break;
                    }
                }
                if(!b){
                    if(i == 1){
                        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                            days = 29;
                        }else {
                            days = 28;
                        }
                    }else {
                        if(i % 2 == 0){
                            days = i < 7 ? 31: 30;
                        }else {
                            days = i < 7 ? 30: 31;
                        }
                    }
                    break;
                }
            }
            if(!b) break;
            System.out.println("Input month is invalid, try again: ");
            month = sc.next();
        }
        System.out.println("The " + month + " of " + year + " has " + days + " days.");

    }
}
