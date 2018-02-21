package com.example.shaad.quizapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shaad.quizapplication.Model.ProfileAccount;
import com.example.shaad.quizapplication.Model.QuestionScore;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SubmitActivity extends AppCompatActivity {
    TextView totalScore_show, totalQuestion_show;
    ProgressBar progressBar;
    Button tryAgainBtn;

    DatabaseReference questionScore;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        database = FirebaseDatabase.getInstance();
        questionScore = database.getReference("Question_Score");//give reference

        totalScore_show = (TextView) findViewById(R.id.totalScore_show);
        totalQuestion_show = (TextView) findViewById(R.id.totalQuestion_show);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tryAgainBtn = (Button) findViewById(R.id.tryAgainBtn);
        progressBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubmitActivity.this, HomeActivity.class));
                finish();
            }
        });

        Intent submitIntent = getIntent();
        if (submitIntent != null) {
            String correctAnswers = submitIntent.getExtras().getString("correctAnswers");
            String totalNumberQuestion = submitIntent.getExtras().getString("totalNumberQuestion");

            totalScore_show.setText(String.format("Total Score : %02d ", Integer.parseInt(correctAnswers) * 10));
            totalQuestion_show.setText(String.format("Total Question : %02d / %02d", Integer.parseInt(correctAnswers), Integer.parseInt(totalNumberQuestion)));

            progressBar.setMax(Integer.parseInt(totalNumberQuestion));
            progressBar.setProgress(Integer.parseInt(correctAnswers));

            questionScore.child(String.format("%s_%s", ProfileAccount.mCurrentUser.getuserName(), ProfileAccount.mSubject.getCode()))
                    .setValue(new QuestionScore(String.format("%s_%s", ProfileAccount.mCurrentUser.getuserName(), ProfileAccount.mSubject.getCode()),
                            ProfileAccount.mCurrentUser.getuserName(),
                            String.valueOf(Integer.parseInt(correctAnswers) * 10)));

        }

    }
}
