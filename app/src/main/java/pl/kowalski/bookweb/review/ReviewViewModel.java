package pl.kowalski.bookweb.review;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * ViewModel dla recenzji.
 *
 * @author Michał Ciołek
 */
public class ReviewViewModel extends AndroidViewModel {

    private ReviewRepository repository;

    private LiveData<List<Review>> allReviews;

    public ReviewViewModel(@NonNull Application application) {
        super(application);

        repository = new ReviewRepository(application);
        allReviews = repository.getAllReviews();
    }

    public LiveData<List<Review>> getAllReviews() {
        return allReviews;
    }

    public void insert(Review word) {
        repository.insert(word);
    }

    public void delete(Review word) {
        repository.delete(word);
    }
}
