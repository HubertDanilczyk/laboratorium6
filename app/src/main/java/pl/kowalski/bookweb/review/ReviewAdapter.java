package pl.kowalski.bookweb.review;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pl.kowalski.bookweb.R;

/**
 * Adapter do obslugi RecyclerView z recenzjami.
 *
 * @author Michał Ciołek
 */
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<Review> reviews;

    public ReviewAdapter() {
        //recenzje nie są ustawiane w konstruktorze tak jak w liście książek lub komentarzach!
    }

    @NonNull
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. utwórz inflater (narzędzie do wczytywania widoków stworzonych w XML
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 2. wczytaj widok jednego wiersza
        View rowView = inflater.inflate(R.layout.review_list_element, parent, false);

        // 3. stwórz obiek ViewHolder, który będzie trzymać odwołania
        // do elementów jednego wiersza (np. tytułu)
        ReviewAdapter.ViewHolder viewHolder = new ReviewAdapter.ViewHolder(rowView);

        // 4. zwróć nowo utworzony obiekt
        return viewHolder;
    }

    /**
     * Ustaw recenzje.
     * W poprzednich rozwiązaniach (lista książek i komentarzy)
     * recenzje były przekazywane przez konstruktor.
     *
     * @param reviews lista recenzji
     */
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {
        //bindowanie danych do konkretnego wiersza
        holder.title.setText(reviews.get(position).title);
        holder.author.setText(reviews.get(position).author);
        holder.text.setText(reviews.get(position).text);
        //wyświetlanie ID
        holder.id.setText(String.valueOf(reviews.get(position).id));
    }

    @Override
    public int getItemCount() {
        // w momencie tworzenia adaptera nie otrzymujemy recenzjie
        // dlatego reviews może być nullem
        if (reviews != null) {
            return reviews.size();
        }

        return 0;
    }

    /**
     * Pozyskaj jedną recenzję z danej pozycji.
     * Lista recenzji może być nullem ponieważ recenzje
     * nie są przekazywane przez konstruktor.
     *
     * @param index pozycja recenzji
     * @return recenzja lub null
     */
    public Review getReview(int index) {
        return (reviews != null) ? reviews.get(index) : null;
    }

    /**
     * Holder dla widoków.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //widgety z review_list_element.xml
        public TextView title;
        public TextView author;
        public TextView text;
        public TextView id;

        public ViewHolder(View itemView) {
            super(itemView);
            //wyszukanie widgetów
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            text = itemView.findViewById(R.id.text);
            id = itemView.findViewById(R.id.id);
        }
    }
}