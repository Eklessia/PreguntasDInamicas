package cl.grupo1.preguntasdinamicas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainFragment extends Fragment {

    TextView textView_QuestionTitle,
            textView_QuestionCategory,
            textView_QuestionDifficulty;
    RadioGroup radioGroup_Options;
    RadioButton radioButton_Option01,
            radioButton_Option02;

    public MainFragment() {
        //  constructor
    }

    public static MainFragment newInstance(String category,
                                           String difficulty,
                                           String question,
                                           String correctAnswer,
                                           List<String> incorrectAnswers){

        MainFragment fragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putString("CATEGORY", category);
        arguments.putString("DIFFICULTY", difficulty);
        arguments.putString("QUESTION", question);
        arguments.putString("CORRECT_ANSWER", correctAnswer);
        arguments.putStringArrayList("INCORRECT_ANSWERS", (ArrayList<String>) incorrectAnswers);

        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final String category = Objects.requireNonNull(getArguments().getString("CATEGORY"));
        final String difficulty = Objects.requireNonNull(getArguments().getString("DIFFICULTY"));
        final String question = Objects.requireNonNull(getArguments().getString("QUESTION"));
        final String correctAnswer = Objects.requireNonNull(getArguments().getString("CORRECT_ANSWER"));
        final List<String> incorrectAnswers = Objects.requireNonNull(getArguments().getStringArrayList("INCORRECT_ANSWERS"));

        initializeViews(view);

        textView_QuestionTitle.setText(question);
        textView_QuestionCategory.setText(category);
        textView_QuestionDifficulty.setText(difficulty);
        radioButton_Option01.setText(incorrectAnswers.get(0));
        radioButton_Option02.setText(correctAnswer);

        return  view;
    }

    private void initializeViews(View view){
        textView_QuestionTitle = view.findViewById(R.id.textView_QuestionTitle);
        textView_QuestionCategory = view.findViewById(R.id.textView_QuestionCategory);
        textView_QuestionDifficulty = view.findViewById(R.id.textView_QuestionDifficulty);
        radioGroup_Options = view.findViewById(R.id.radioGroup_Options);
        radioButton_Option01 = view.findViewById(R.id.radioButton_Option01);
        radioButton_Option02 = view.findViewById(R.id.radioButton_Option02);
    }
}




