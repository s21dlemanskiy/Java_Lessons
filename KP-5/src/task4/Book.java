package task4;

public class Book {
    final String author_name;
    final String book_name;

    public Book(String author_name, String book_name) {
        this.author_name = author_name;
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getBook_name() {
        return book_name;
    }
}
