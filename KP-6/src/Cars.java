public enum Cars {
    CAR1("1F-g", 20, Mark.AUDI, 200000, Color.RED),
    CAR2("1F-g", 90, Mark.KIA, 400000, Color.BLUE),
    CAR3("1F-g", 220, Mark.AUDI, 200201020, Color.GREEN),
    CAR4("1F-g", 110, Mark.BMW,1039929, Color.BLACK),
    CAR5("1F-g", 100, Mark.AUDI,230000, Color.BLACK);

    final String name;
    final int max_speed;
    final Mark mark;
    double price;
    Color color;

    Cars(String name, int max_speed, Mark mark, double price, Color color) {
        this.name = name;
        this.max_speed = max_speed;
        this.mark = mark;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "name='" + name + '\'' +
                ", max_speed=" + max_speed +
                ", mark=" + mark +
                ", price=" + price +
                ", color=" + color +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public Mark getMark() {
        return mark;
    }

    public double getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }
}
