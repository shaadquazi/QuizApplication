package com.example.shaad.quizapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaad.quizapplication.Model.ItemClickListener;
import com.example.shaad.quizapplication.Model.QuestionBank;
import com.example.shaad.quizapplication.Model.Subject;
import com.example.shaad.quizapplication.Model.SubjectViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;


public class SubjectFragment extends Fragment {

    View myFragment;
    private FirebaseRecyclerAdapter<Subject, SubjectViewHolder> mSubjectListAdapter;
    private DatabaseReference mDatabase;
    private RecyclerView listSubject;
    private LinearLayoutManager layoutManager;


    public static SubjectFragment newInstance() {
        return new SubjectFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("SubjectTest");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_subject, container, false);
        listSubject = (RecyclerView) myFragment.findViewById(R.id.listSubject);
        listSubject.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listSubject.setLayoutManager(layoutManager);

        loadSubjects();

        return myFragment;
    }

    private void loadSubjects() {
        mSubjectListAdapter = new FirebaseRecyclerAdapter<Subject, SubjectViewHolder>(Subject.class, R.layout.subject_row, SubjectViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(SubjectViewHolder viewHolder, final Subject model, int position) {


                String name = model.getName();
                String credit = model.getCredits();
                String code = model.getCode();
                Map<String, QuestionBank> questionBankMap = model.getQuestionBank();

                final Subject subject = new Subject(name, code, credit, questionBankMap);


                viewHolder.subjectName.setText(subject.getName());
                viewHolder.subjectCredit.setText(subject.getCredits());
                viewHolder.subjectCode.setText(subject.getCode());

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent toInstruction = new Intent(getActivity(), InstructionActivity.class);
                        toInstruction.putExtra("subjectObject", subject);
                        startActivity(toInstruction);
                    }
                });
            }


        };
        mSubjectListAdapter.notifyDataSetChanged();
        listSubject.setAdapter(mSubjectListAdapter);
    }
}
