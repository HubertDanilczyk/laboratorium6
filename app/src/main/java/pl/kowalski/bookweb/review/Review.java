package pl.kowalski.bookweb.review;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Recenzja
 *
 * @author Michał Ciołek
 */
@Entity
public class Review {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String author;
    public String title;
    public String text;
}