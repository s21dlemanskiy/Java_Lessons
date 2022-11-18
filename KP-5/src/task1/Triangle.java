package task1;

public class Triangle implements Area{
    final Point p1;
    final Point p2;
    final Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle() {
        this.p1 = Point.parce_point();
        this.p2 = Point.parce_point();
        this.p3 = Point.parce_point();
    }


    @Override
    public double calculateArea() {
        double a = this.p1.distance(this.p2);
        double b = this.p1.distance(this.p3);
        double c = this.p3.distance(this.p2);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
