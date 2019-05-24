package pl.kowalski.bookweb.review;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReviewDao {

    @Insert
    void insert(Review word);

    @Delete
    void delete(Review word);

    @Query("SELECT * from Review")
    LiveData<List<Review>> getAllReviews();
}

