package task1;

import java.lang.Math;
import java.util.Scanner;

public class Point {
    private double x;
    private double y;
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Point(int x, int y){
        this.x = (double) x;
        this.y = (double) y;
    }
    public double distance(Point other){
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y- other.y, 2));
    }
    public double distance_by_x(Point other){
        return Math.abs(this.x - other.x);
    }
    public double distance_by_y(Point other){
        return Math.abs(this.y - other.y);
    }
    public static Point parce_point(){
        Scanner sc = new Scanner(System.in);
        System.out.print("point_x:");
        double x = sc.nextDouble();
        System.out.print("\n");
        System.out.print("point_y:");
        double y = sc.nextDouble();
        System.out.print("\n---------------------\n");
        return new Point(x, y);
    }
}
