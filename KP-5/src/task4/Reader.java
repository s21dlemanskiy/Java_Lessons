package task4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

class FIO{
    public String firstName;
    public String secondName;
    public String lastName;

    public FIO(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public String short_v(){
        return this.firstName + " " + this.secondName.charAt(0) + ". " + this.lastName.charAt(0) + ".";
    }
}



public class Reader {
    final FIO fio;
    final int id;
    final String faculty;
    final LocalDate dateOfBirth;
    final String number;

    public Reader(FIO fio, int id, String faculty, LocalDate dateOfBirth, String number) {
        this.fio = fio;
        this.id = id;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.number = number;
    }

    public Reader(FIO fio, int id, String faculty, int dateOfBirthDay, int dateOfBirthMonth, int dateOfBirthYear, String number) {
        this.fio = fio;
        this.id = id;
        this.faculty = faculty;
        this.dateOfBirth = LocalDate.of(dateOfBirthYear, dateOfBirthMonth, dateOfBirthDay);
        this.number = number;
    }

    public Reader(String firstName, String secondName, String lastName, int id, String faculty, int dateOfBirthDay, int dateOfBirthMonth, int dateOfBirthYear, String number) {
        this.fio = new FIO(firstName, secondName, lastName);
        this.id = id;
        this.faculty = faculty;
        this.dateOfBirth = LocalDate.of(dateOfBirthYear, dateOfBirthMonth, dateOfBirthDay);
        this.number = number;
    }
    public void takeBook(){

    }
    public void returnBook(){

    }
    public void takeBook(int coutBooksTaken){
        System.out.println(this.fio.short_v() + " взял "+ Integer.toString(coutBooksTaken)+ " книги");
    }
    public void takeBook(String...books){
        System.out.println(this.fio.short_v() + " взял:" + String.join(", ", books));
    }
    public void takeBook(Book...books){
        System.out.println(this.fio.short_v() + " взял:" +  Arrays.stream(books).map(Book::getBook_name).collect(Collectors.joining(", ")));
    }
    public void returnBook(int coutBooksTaken){
        System.out.println(this.fio.short_v() + " вернул "+ Integer.toString(coutBooksTaken)+ " книги");
    }
    public void returnBook(String...books){
        System.out.println(this.fio.short_v() + " вернул:" + String.join(", ", books));
    }
    public void returnBook(Book...books){
        System.out.println(this.fio.short_v() + " вернул:" + Arrays.stream(books).map(Book::getBook_name).collect(Collectors.joining(", ")));
    }
}
