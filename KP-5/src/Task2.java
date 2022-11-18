import task1.*;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void task2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("N:");
        int n = sc.nextInt();
        Area[] figure = new Area[n];
        for (int i = 0; i < n; i++) {
            figure[i] = Task1.parseFig();
        }
        double[] squares = Arrays.stream(figure).mapToDouble(Area::calculateArea).toArray();
        System.out.println(Arrays.stream(squares).sum());
    }
}
