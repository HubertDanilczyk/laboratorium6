package pl.kowalski.bookweb.activities.review;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import pl.kowalski.bookweb.R;
import pl.kowalski.bookweb.review.Review;
import pl.kowalski.bookweb.review.ReviewViewModel;

/**
 * Aktywność dodająca nową recenzję.
 *
 * @author Michał Ciołek
 */
public class AddReviewActivity extends AppCompatActivity {

    ReviewViewModel reviewViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_review);

        reviewViewModel = ViewModelProviders.of(this).get(ReviewViewModel.class);
    }

    /**
     * Akcja dodania nowej recenzji wywoływana przez przycisk.
     *
     * @param view
     */
    public void addReview(View view) {
        //1. odwołanie do widgetów
        EditText authorEditText = findViewById(R.id.author);
        EditText titleEditText = findViewById(R.id.title);
        EditText textEditText = findViewById(R.id.text);

        Review review = new Review();
        review.author = authorEditText.getText().toString();
        review.text = textEditText.getText().toString();
        review.title = titleEditText.getText().toString();

        reviewViewModel.insert(review);

        Toast.makeText(this, "Recenzja dodana!", Toast.LENGTH_SHORT).show();

        authorEditText.setText("");
        textEditText.setText("");
        titleEditText.setText("");
    }
}
