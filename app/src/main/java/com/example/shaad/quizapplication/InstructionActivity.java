package com.example.shaad.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shaad.quizapplication.Model.Subject;

public class InstructionActivity extends AppCompatActivity {
    TextView userSelectedSubject;
    Button startTest_btn;


    Subject subject;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);


        Intent instructionIntent = getIntent();
        subject = (Subject) instructionIntent.getSerializableExtra("subjectObject");
        userSelectedSubject = (TextView) findViewById(R.id.userSelectedSubject);
        userSelectedSubject.setText(subject.getName());





        startTest_btn = (Button) findViewById(R.id.startTest_btn);
        startTest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTest_btn_Clicked();
            }
        });

    }


    private void startTest_btn_Clicked() {

        Intent startTest = new Intent(InstructionActivity.this, TestActivity.class);
        startTest.putExtra("subjectObject", subject);
        startActivity(startTest);
        finish();
        //submit test here
        //go to test result
    }


}
