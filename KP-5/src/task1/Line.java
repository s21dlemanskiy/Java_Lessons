package task1;//package task1.Point;

public class Line{
    final Point p1;
    final Point p2;
    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public double length(){
        return this.p1.distance(this.p2);
    }
}
