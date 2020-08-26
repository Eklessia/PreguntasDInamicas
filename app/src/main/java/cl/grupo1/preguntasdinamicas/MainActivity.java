package cl.grupo1.preguntasdinamicas;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import cl.grupo1.preguntasdinamicas.api.Api;
import cl.grupo1.preguntasdinamicas.api.RetrofitClient;
import cl.grupo1.preguntasdinamicas.media.Question;
import cl.grupo1.preguntasdinamicas.media.QuestionList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Api service = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<QuestionList> call = service.getQuestion();
        call.enqueue(new Callback<QuestionList>() {

            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                QuestionList list = response.body();
                if (list != null){
                    Question question = list.getQuestionList().get(0);
                    MainFragment fragment = MainFragment.newInstance(
                            question.getCategory(),
                            question.getDifficulty(),
                            question.getQuestion(),
                            question.getCorrectAnswer(),
                            question.getIncorrectAnswers()
                    );
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container, fragment, "FRAGMENTO").commit();
                }
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: no se puede leer la database", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
