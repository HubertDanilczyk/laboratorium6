package pl.kowalski.bookweb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import pl.kowalski.bookweb.review.Review;
import pl.kowalski.bookweb.review.ReviewDao;

@Database(entities = {Review.class}, version = 1)
public abstract class BookWebDatabase extends RoomDatabase {

    private static BookWebDatabase INSTANCE;

    public static BookWebDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookWebDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BookWebDatabase.class, "book_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ReviewDao reviewDao();

}
