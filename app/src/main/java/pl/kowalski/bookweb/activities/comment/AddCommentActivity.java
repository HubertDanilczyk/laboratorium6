package pl.kowalski.bookweb.activities.comment;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import pl.kowalski.bookweb.R;

/**
 * Aktywność dodająca nowy komentarz.
 *
 * @author Michał Ciołek
 */
public class AddCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_comment);
    }

    public void addComment(View view) {
        //TODO 1. inicjalizacja pól tekstowych

        //TODO 2. weryfikacja

        //TODO 3. tworzenie nowego komentarza

        //TODO 4. wysłanie komentarza na serwer
    }
}
