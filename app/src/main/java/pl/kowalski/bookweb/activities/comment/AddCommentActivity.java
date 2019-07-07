package pl.kowalski.bookweb.activities.comment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pl.kowalski.bookweb.BookWebApplication;
import pl.kowalski.bookweb.BookWebService;
import pl.kowalski.bookweb.R;
import pl.kowalski.bookweb.comment.Comment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Aktywność dodająca nowy komentarz.
 *
 * @author Michał Ciołek
 */
public class AddCommentActivity extends AppCompatActivity {
    private EditText author,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_comment);
        Button button;
        button = findViewById(R.id.add_comment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();
            }
        });

    }

    public void addComment() {
        //TODO 1. inicjalizacja pól tekstowych
        author = findViewById(R.id.author);
        text = findViewById(R.id.comment);

        //TODO 2. weryfikacja
        if(author.getText().toString().isEmpty()){
            Toast.makeText(AddCommentActivity.this,"Wprowadź autora",Toast.LENGTH_SHORT).show();
        } else if(text.getText().toString().isEmpty()){
            Toast.makeText(AddCommentActivity.this,"Wprowadź treść komentarza",Toast.LENGTH_SHORT).show();
        } else {

            //TODO 3. tworzenie nowego komentarza
            Comment comment = new Comment();
            comment.setAuthor(author.getText().toString());
            comment.setText(text.getText().toString());

            //TODO 4. wysłanie komentarza na serwer
            Log.d("AddCommentActivity", comment.toString());
            BookWebApplication application = (BookWebApplication) this.getApplication();
            BookWebService bookWebService =  application.getBookWebService();
            Call<Comment> addNewCommentCall = bookWebService.createComment(comment);
            addNewCommentCall.enqueue(new Callback<Comment>() {
                @Override
                public void onResponse(Call<Comment> call, Response<Comment> response) {
                    Log.d("Response",response.toString());
                    if(response.isSuccessful()){
                        Integer newId = response.body().getId();
                        Toast.makeText(AddCommentActivity.this,String.valueOf(newId),Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Comment> call, Throwable t) {

                }
            });
        }
    }
}
