package task3;

public class Task3 {
    public static void task3(){
        Phone p1 = new Phone("+79394521341", "LG-340", 500);
        Phone p2 = new Phone("+7-939-452-13-41", "LG-350", 700);
        Phone p3 = new Phone("+7-939-452-13-41", "LG-370", 800);
        for (Phone p: new Phone[] {p1, p2, p3}) {
            System.out.println("Model:"+ p.getModel() + "\nNumber:" + p.getNumber() + "\nWieght:" + Double.toString(p.getWeight()));
            p.receiveCall("Garic Huyaric");
        }

    }

}
