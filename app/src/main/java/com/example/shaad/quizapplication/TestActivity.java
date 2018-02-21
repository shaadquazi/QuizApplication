package com.example.shaad.quizapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaad.quizapplication.Model.ProfileAccount;
import com.example.shaad.quizapplication.Model.QuestionBank;
import com.example.shaad.quizapplication.Model.Subject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    final static int HALF_HOUR = 1800000;
    final static int FULL_HOUR = 3600000;
    TextView timeCount;
    Subject subject;
    List<QuestionBank> questionBanks;


    int totalNumberQuestion;
    int currentQuestion;
    int correctAnswers;
    int index = 0;

    //for questionSpace
    TextView textQuestion;
    ImageView imageQuestion;

    //forquestionDashboard
    TextView totalScore, totalQuestion;

    //option
    RadioGroup allOption;
    RadioButton optionA, optionB, optionC, optionD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        setTimer();
        init();


        showQuestion(index);


        //28.00 submit test


        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toSubmit = new Intent(TestActivity.this, SubmitActivity.class);
                toSubmit.putExtra("correctAnswers", String.valueOf(correctAnswers));
                toSubmit.putExtra("totalNumberQuestion", String.valueOf(totalNumberQuestion));
                startActivity(toSubmit);
                finish();

            }
        });


        allOption.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                if (index < totalNumberQuestion) {
                    RadioButton selectedOption = (RadioButton) group.findViewById(checkedId);
                    if (null != selectedOption && checkedId > -1) {

                        if (selectedOption.getText().equals(questionBanks.get(index).getCorrectAnswer())) {
                            //CORRECT ANSWER
                            correctAnswers++;
                        } else {
                            //WRONG ANSWER
                        }
                        showQuestion(++index);
                        totalScore.setText("Total Score : " + String.format("%02d", correctAnswers * 10) + " / " + String.format("%02d", totalNumberQuestion * 10));
                    }
                }
            }
        });


    }

    private void showQuestion(int index) {
        allOption.clearCheck();
        if (index < totalNumberQuestion) {
            totalQuestion.setText("Total Question : " + String.format("%02d", index + 1) + " / " + String.format("%02d", totalNumberQuestion));
            currentQuestion++;
            if (questionBanks.get(index).getImageQuestion().equals("true")) {
                //Image to diplay
                Picasso.with(getBaseContext())
                        .load(questionBanks.get(index).getQuestionText())
                        .into(imageQuestion);
                imageQuestion.setVisibility(View.VISIBLE);
                textQuestion.setVisibility(View.INVISIBLE);
            } else {
                textQuestion.setText(questionBanks.get(index).getQuestionText());
                textQuestion.setVisibility(View.VISIBLE);
                imageQuestion.setVisibility(View.INVISIBLE);
            }
            optionA.setText(questionBanks.get(index).getOption1());
            optionB.setText(questionBanks.get(index).getOption2());
            optionC.setText(questionBanks.get(index).getOption3());
            optionD.setText(questionBanks.get(index).getOption4());
        } else {
            //if final question submit score
            Intent toSubmit = new Intent(TestActivity.this, SubmitActivity.class);
            toSubmit.putExtra("correctAnswers", String.valueOf(correctAnswers));
            toSubmit.putExtra("totalNumberQuestion", String.valueOf(totalNumberQuestion));
            startActivity(toSubmit);
            finish();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        totalNumberQuestion = questionBanks.size();

    }


    private void init() {
        Intent testIntent = getIntent();
        subject = (Subject) testIntent.getSerializableExtra("subjectObject");
        questionBanks = new ArrayList<>(subject.getQuestionBank().values());
        totalNumberQuestion = questionBanks.size();
        Collections.shuffle(questionBanks);


        textQuestion = (TextView) findViewById(R.id.textQuestion);
        imageQuestion = (ImageView) findViewById(R.id.imageQuestion);

        totalScore = (TextView) findViewById(R.id.totalScore);
        totalQuestion = (TextView) findViewById(R.id.totalQuestion);


        allOption = (RadioGroup) findViewById(R.id.allOptions);
        optionA = (RadioButton) findViewById(R.id.optionA);
        optionB = (RadioButton) findViewById(R.id.optionB);
        optionC = (RadioButton) findViewById(R.id.optionC);
        optionD = (RadioButton) findViewById(R.id.optionD);
        ProfileAccount.mSubject = subject;
    }


    private void setTimer() {
        timeCount = (TextView) findViewById(R.id.timeCount);
        new CountDownTimer(FULL_HOUR, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
                int hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                String time = "Time Remaining :\n" + String.format("%02d Hr", hours) + " : " + String.format("%02d Min", minutes) + " : " + String.format("%02d Sec", seconds);
                timeCount.setText(time);
                if (minutes == 5 && seconds == 0) {
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    Toast.makeText(TestActivity.this, "5 Min Remaining !", Toast.LENGTH_SHORT).show();
                    v.vibrate(500);
                }
            }

            public void onFinish() {
                Resources res = getResources();
                String finish_msg = res.getString(R.string.finish_msg);
                timeCount.setText(finish_msg);
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(500);
            }
        }.start();
    }
}
