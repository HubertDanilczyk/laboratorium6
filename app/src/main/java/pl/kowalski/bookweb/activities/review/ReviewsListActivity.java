package pl.kowalski.bookweb.activities.review;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pl.kowalski.bookweb.R;
import pl.kowalski.bookweb.review.Review;
import pl.kowalski.bookweb.review.ReviewAdapter;
import pl.kowalski.bookweb.review.ReviewViewModel;

/**
 * Aktywność wyświetlająca listę recenzji.
 *
 * @author Michał Ciołek
 */
public class ReviewsListActivity extends AppCompatActivity {

    private ReviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews_list);

        // Deklaracja i inicjalizacja ViewModel
        final ReviewViewModel reviewViewModel = ViewModelProviders.of(this).get(ReviewViewModel.class);
        reviewViewModel.getAllReviews().observe(this, new Observer<List<Review>>() {
            @Override
            public void onChanged(@Nullable final List<Review> words) {
                // pojawiły się nowe recenzje,
                // zaktualizuj recenzje w adapterze
                adapter.setReviews(words);
            }
        });

        // znajdź RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // ustawienie sposobu rozmieszczenia elementów
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // utworzenie adaptera
        // zwróć uwagę, że recenzje nie są przekazywane do adaptera przez konstruktor
        // recenzje zostaną przekazane później za pomocą setReviews(...)
        adapter = new ReviewAdapter();

        // połączenie adaptera z RecyclerView
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
                //pozycja "swipniętego" wiersza
                final int position = viewHolder.getAdapterPosition();

                Review reviewToDelete = adapter.getReview(position);
                reviewViewModel.delete(reviewToDelete);

                Toast.makeText(ReviewsListActivity.this, "Usunięto recenzję", Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
