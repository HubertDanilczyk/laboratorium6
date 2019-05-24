package pl.kowalski.bookweb.book;

import java.util.Date;

/**
 * Created by Michał Ciołek.
 */
public class Book {

    private String author;
    private String title;
    private Date date;

    public Book() {
        this.author = "unknown";
        this.title = "unknown";
        this.date = new Date(1970, 0, 1);
    }

    public Book(String author, String title, Date date) {
        this.author = author;
        this.title = title;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", text=" + date +
                '}';
    }
}
