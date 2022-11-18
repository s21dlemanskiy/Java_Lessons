package task1;

import java.util.Scanner;

public class Task1 {
    public static Area parseFig(){
        System.out.println("Type_figure(Triangle, Cercle, Rectangle, Squre):");
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        type = type.replace("\n", "");
        Area data;
        switch (type) {
            case ("Triangle"):
                data = new Triangle();
                break;

            case ("Rectangle"):
                data = new Rectangle();
                break;

            case ("Squre"):
                data = new Squre();
                break;

            case ("Cercle"):
                data = new Cercle();
                break;

            default:
                data = new Squre();
                break;
        }
        return data;
    }
    public static void task1() {
        Area data = parseFig();
        System.out.println(data.calculateArea());
    }
}
