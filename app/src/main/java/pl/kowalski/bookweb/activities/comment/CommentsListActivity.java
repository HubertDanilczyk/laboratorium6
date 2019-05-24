package pl.kowalski.bookweb.activities.comment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pl.kowalski.bookweb.R;
import pl.kowalski.bookweb.comment.CommentAdapter;

/**
 * Aktywność wyświetlająca listę komentarzy.
 *
 * @author Michał Ciołek
 */
public class CommentsListActivity extends AppCompatActivity {

    private CommentAdapter commentsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_list);

        // TODO Spinner

        // znajdź RecyclerView
        RecyclerView commentListRecyclerView = findViewById(R.id.comments_list_recycler_view);

        // ustawienie sposobu rozmieszczenia elementów
        commentListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // utworzenie adaptera wraz z komentarzami odczytanymi z pliku
        commentsListAdapter = new CommentAdapter();

        // połączenie adaptera z RecyclerView
        commentListRecyclerView.setAdapter(commentsListAdapter);

        downloadComments(2);
    }

    /**
     * Pobieranie komentarzy z Rest API
     *
     * @param size liczba pobranych komentarzy
     */
    private void downloadComments(int size) {
        //1. pobranie komentarzy z serwera

        //2. przekazanie komentarzy do commentsListAdapter
    }
}
