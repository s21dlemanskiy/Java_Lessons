package task1;

public class Rectangle implements Area{
    final Point p1;
    final Point p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    public Rectangle() {
        this.p1 = Point.parce_point();
        this.p2 = Point.parce_point();
    }

    @Override
    public double calculateArea() {
        return this.p1.distance_by_x(this.p2) * this.p1.distance_by_y(this.p2);
    }

}
