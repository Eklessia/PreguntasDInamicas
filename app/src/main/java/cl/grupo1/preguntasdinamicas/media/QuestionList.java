package cl.grupo1.preguntasdinamicas.media;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionList {

    @SerializedName("response_code")
    private int responseCode;
    @SerializedName("results")
    private List<Question> questionList;

    public int getResponseCode() { return responseCode; }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
