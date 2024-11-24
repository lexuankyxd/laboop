import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        System.out.println("Input the matrix dimensions(in the format: n m): ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while (n <= 0){
            System.out.println("N must be greater than 0, enter again: ");
            n = sc.nextInt();
        }

        while (m <= 0){
            System.out.println("M must be greater than 0, enter again: ");
            m = sc.nextInt();
        }

        double[][] a = new double[n][m];
        double[][] b = new double[n][m];
        double[][] c = new double[n][m];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                a[i][j] = sc.nextDouble();
            }
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                b[i][j] = sc.nextDouble();
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
