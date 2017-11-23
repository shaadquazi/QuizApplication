package com.example.shaad.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InstructionActivity extends AppCompatActivity {
    TextView userSelectedSubject;
    Button startTest_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        setTopTextViewWithSubject();
        startTest_btn = (Button) findViewById(R.id.startTest_btn);
        startTest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTest_btn_Clicked();
            }
        });

    }

    private void startTest_btn_Clicked() {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
    }

    private void setTopTextViewWithSubject() {
        Intent instructionIntent = getIntent();
        userSelectedSubject = (TextView) findViewById(R.id.userSelectedSubject);
        userSelectedSubject.setText("Selected Subject\n" + instructionIntent.getSerializableExtra("subjectName"));
    }


}
