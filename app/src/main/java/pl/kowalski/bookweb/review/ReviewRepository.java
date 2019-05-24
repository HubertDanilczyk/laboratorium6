package pl.kowalski.bookweb.review;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import pl.kowalski.bookweb.BookWebDatabase;

/**
 * Repozytorium dla recenzji.
 *
 * @author Michał Ciołek
 */
public class ReviewRepository {

    private ReviewDao reviewDao;
    private LiveData<List<Review>> allReviews;

    ReviewRepository(Application application) {
        BookWebDatabase db = BookWebDatabase.getDatabase(application);
        reviewDao = db.reviewDao();
        allReviews = reviewDao.getAllReviews();
    }

    LiveData<List<Review>> getAllReviews() {
        return allReviews;
    }

    public void delete(final Review word) {
        new Thread(new Runnable() {
            public void run() {
                reviewDao.delete(word);
            }
        }).start();
    }

    public void insert(final Review word) {
        new Thread(new Runnable() {
            public void run() {
                reviewDao.insert(word);
            }
        }).start();
    }
}