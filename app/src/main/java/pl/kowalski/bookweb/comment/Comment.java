package pl.kowalski.bookweb.comment;

/**
 * Model opisujący komentarz pobrany z Rest API.
 * <p>
 * Created by Michał Ciołek.
 */
public class Comment {
    // TODO
    String author, text, time;
    Integer id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                ", id=" + id +
                '}';
    }
}
