package task3;

public class Phone {
    final String number;
    final String model;
    final double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }
    public void receiveCall(String nameInCall){
        System.out.println("Звонит " + nameInCall);
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
        this.weight = -1;
    }

    public Phone() {
        this.number = "";
        this.model = "";
        this.weight = -1;
    }
    public void receiveCall(String nameInCall, String numberInCall){
        System.out.println("Звонит:" + nameInCall + "\nС номера:" + numberInCall);

    }
    public void sendMessage(String...vars){
        for (String number:vars) {
            System.out.println(number);
        }
    }
}
