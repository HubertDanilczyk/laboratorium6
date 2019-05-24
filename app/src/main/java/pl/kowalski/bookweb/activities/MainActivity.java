package pl.kowalski.bookweb.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import pl.kowalski.bookweb.R;

/**
 * Aktywność startowa.
 *
 * @author Michał Ciołek
 */
public class MainActivity extends AppCompatActivity {

    // nazwa pliku ustawień
    public static final String SETTINGS_PREFS = "settings";

    // klucz do imienia w ustawieniach
    public static final String NAME_PREFS = "USER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences(SETTINGS_PREFS, Context.MODE_PRIVATE);

        if (sharedPref.getString(NAME_PREFS, null) != null) {
            goHome();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_program:
                Intent intent = new Intent(this, AboutProgramActivity.class);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    /**
     * Pobranie od użytkownika imienia
     *
     * @param view widok naciśniętego przycisku
     */
    public void onGoNextClick(View view) {
        EditText nameEditText = findViewById(R.id.nameEditText);
        if (!nameEditText.getText().toString().isEmpty()) {
            nameEditText.setError(null);
            SharedPreferences sharedPref = getSharedPreferences(SETTINGS_PREFS, Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPref.edit();

            edit.putString(NAME_PREFS, nameEditText.getText().toString());

            edit.apply();
            goHome();
        } else {
            nameEditText.setError("Podaj imię!");
        }
    }

    /**
     * Uruchom aktywność z menu.
     */
    private void goHome() {
        finish();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
