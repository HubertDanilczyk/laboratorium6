package pl.kowalski.bookweb;

import java.util.List;

import pl.kowalski.bookweb.comment.Comment;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BookWebService {
    @GET("comments")
    Call<List<Comment>> listComments();
    @POST("comments")
    Call<Comment> createComment(@Body Comment comment);

}
