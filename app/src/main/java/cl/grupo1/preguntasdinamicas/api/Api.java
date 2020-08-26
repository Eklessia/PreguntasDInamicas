package cl.grupo1.preguntasdinamicas.api;

import cl.grupo1.preguntasdinamicas.media.QuestionList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET ("api.php?amount=1&category=18&difficulty=medium&type=boolean")
    Call<QuestionList> getQuestion();
}
