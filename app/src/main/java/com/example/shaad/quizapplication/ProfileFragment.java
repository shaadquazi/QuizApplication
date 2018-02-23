package com.example.shaad.quizapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaad.quizapplication.Model.ProfileAccount;
import com.example.shaad.quizapplication.Model.QuestionScore;
import com.example.shaad.quizapplication.Model.Ranking;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {

    FirebaseDatabase database;
    DatabaseReference questionScore;
    int totalScore = 0;
    //your details portion
    TextView user_name,user_type,user_branch,user_semester,user_section;




    View myFragment;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        questionScore = database.getReference("Question_Score");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_profile, container, false);

        user_name = (TextView) myFragment.findViewById(R.id.user_name);
        user_type = (TextView) myFragment.findViewById(R.id.user_type);
        user_branch = (TextView) myFragment.findViewById(R.id.user_branch);
        user_semester = (TextView) myFragment.findViewById(R.id.user_semester);
        user_section = (TextView) myFragment.findViewById(R.id.user_section);

        user_name.setText("Name\n"+ProfileAccount.mCurrentUser.getuserName());
        user_type.setText("Acc. Type\n"+ProfileAccount.mCurrentUser.getUserType());
        user_branch.setText("Department\n"+ProfileAccount.mCurrentUser.getBranch());
        user_semester.setText("Semester\n"+ProfileAccount.mCurrentUser.getSemester());
        user_section.setText("Section\n"+ProfileAccount.mCurrentUser.getSection());


        //updateScore(ProfileAccount.mCurrentUser.getuserName());

        return myFragment;
    }



    private void updateScore(final String userName) {

        questionScore.orderByChild("user").equalTo(userName)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot data:dataSnapshot.getChildren()){
                            QuestionScore question = data.getValue(QuestionScore.class);
                            totalScore += Integer.parseInt(question.getScore());
                        }

                        //Ranking ranking = new Ranking(userName,totalScore);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

    }
}
