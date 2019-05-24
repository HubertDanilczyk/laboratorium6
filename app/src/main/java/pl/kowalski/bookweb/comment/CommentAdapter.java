package pl.kowalski.bookweb.comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pl.kowalski.bookweb.R;

/**
 * Adapter dla komentarzy.
 * <p>
 * Created by Michał Ciołek.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<Comment> comments;

    public CommentAdapter() {
        // komentarze nie są ustawiane w konstruktorze tak jak w liście książek tylko po pobraniu z internetu
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. utwórz inflater (narzędzie do wczytywania widoków stworzonych w XML
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 2. wczytaj widok jednego wiersza
        View rowView = inflater.inflate(R.layout.comment_list_element, parent, false);

        // 3. stwórz obiek ViewHolder, który będzie trzymać odwołania
        // do elementów jednego wiersza (np. tytułu)
        ViewHolder viewHolder = new ViewHolder(rowView);

        // 4. zwróć nowo utworzony obiekt
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
        // TODO wyświetlanie treści komentarza
        // holder.comment.setText(comments.get(position)......);
    }

    @Override
    public int getItemCount() {
        return (comments != null) ? comments.size() : 0;
    }

    /**
     * Ustaw komentarze.
     * W poprzednich rozwiązaniach (lista książek)
     * recenzje były przekazywane przez konstruktor.
     *
     * @param comments lista komentarzy
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;

        // odśwież RecyclerView
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //widgety z comment_list_element.xml
        public TextView comment;

        public ViewHolder(View itemView) {
            super(itemView);
            //wyszukanie widgetów
            comment = itemView.findViewById(R.id.comment);
        }
    }
}
