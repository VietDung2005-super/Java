import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n nguyen duong: ");
        int n = scanner.nextInt();

        while (n <= 0) {
            System.out.print("n phai la so nguyen duong. Nhap lai n: ");
            n = scanner.nextInt();
        }

        if (n % 2 != 0) {
            n = n - 1;
        }

        long s = 0;
        for (int i = 2; i <= n; i += 2) {
            s += i;
        }

        System.out.println("Tong s = " + s);

        scanner.close();
    }
}