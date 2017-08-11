package com.ponroy.florian.topquiz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ponroy.florian.topquiz.R;
import com.ponroy.florian.topquiz.model.Question;
import com.ponroy.florian.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        mScore = 0;
        mNumberOfQuestions = 4;

        // Wire widgets
        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        // Use the tag property to 'name' the buttons
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            // Good answer
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            // Wrong answer
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        if (--mNumberOfQuestions == 0) {
            // End the game
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void displayQuestion(final Question question) {
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(3));
    }

    private QuestionBank generateQuestions() {
        Question question1 = new Question("What is the name of the current french president?",
                                          Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                                          1);

        Question question2 = new Question("How many countries are there in the European Union?",
                                          Arrays.asList("15", "24", "28", "32"),
                                          2);

        Question question3 = new Question("Who is the creator of the Android operating system?",
                                          Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                                          0);

        Question question4 = new Question("When did the first man land on the moon?",
                                          Arrays.asList("1958", "1962", "1967", "1969"),
                                          3);

        Question question5 = new Question("What is the capital of Romania?",
                                          Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                                          0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                                          Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                                          1);

        Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                                          Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                                          2);

        Question question8 = new Question("What is the country top-level domain of Belgium?",
                                          Arrays.asList(".bg", ".bm", ".bl", ".be"),
                                          3);

        Question question9 = new Question("What is the house number of The Simpsons?",
                                          Arrays.asList("42", "101", "666", "742"),
                                          3);

        return new QuestionBank(Arrays.asList(question1,
                                              question2,
                                              question3,
                                              question4,
                                              question5,
                                              question6,
                                              question7,
                                              question8,
                                              question9));
    }
}
