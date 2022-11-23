import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static ArrayList<Cars> findCars(double max_price){
        ArrayList<Cars> data = new ArrayList<Cars>();
        for (Cars car:Cars.values()){
            if (car.getPrice() < max_price){
                data.add(car);
            }
        }
        return data;
    }

    public static void task2() {
        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        ArrayList<Cars> cars = findCars(price);
        cars.sort(Comparator.comparing(Cars::getMax_speed));
        for (Cars car:cars){
            System.out.println(car);
        }

    }

    public static void task1(){
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        Month month = Month.values()[index];
        switch (month){
            case JAN ->{System.out.println("Январь");}
            case FEB ->{System.out.println("Февраль");}
            case MAR ->{System.out.println("март");}
            case MAY ->{System.out.println("Май");}
            default -> throw new IllegalStateException("Unexpected value: " + month);
        }
        System.out.println(month.getName());
    }

    public static void main(String[] args) {
//        task1();
        task2();

    }
}