package task4;

public class Task4 {
    public static void task4(){
        Reader a = new Reader("Kotty", "Lemsnkiy", "Yorich", 10000, "WISH", 10, 12, 2022, "+7-982-345-67-34");
        a.returnBook("Приключения", "Словарь", "Энциклопедия");
        Book b1 = new Book("smbd", "Harry Potter");
        Book b2 = new Book("smbd", "Harry Potter2");
        a.takeBook(b1, b2);
        a.takeBook(3);
    }
}
