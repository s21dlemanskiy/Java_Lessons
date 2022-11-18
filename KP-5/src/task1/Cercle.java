package task1;

import java.lang.Math;
import java.util.Scanner;

public class Cercle implements Area{
    final Point center;
    final double radius;

    public Cercle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    public Cercle() {
        this.center =  Point.parce_point();
        Scanner sc = new Scanner(System.in);
        System.out.print("radius:");
        this.radius = sc.nextDouble();
        System.out.print("\n");
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
