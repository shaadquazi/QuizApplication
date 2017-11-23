package com.example.shaad.quizapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shaad.quizapplication.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {
    //for sign up
    MaterialEditText edtNewuserName, edtNewPassword, edtNewBranch;
    Spinner spnNewSelectUser, spnNewSemester, spnNewSection;

    //for sign in
    MaterialEditText edtuserName, edtPassword;
    Button btnSignin, btnSignup;

    DatabaseReference mDatabaseUsers;


    User user = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseUsers = FirebaseDatabase.getInstance().getReference("Users");

        edtuserName = (MaterialEditText) findViewById(R.id.edtuserName);
        edtPassword = (MaterialEditText) findViewById(R.id.edtPassword);

        btnSignin = (Button) findViewById(R.id.btn_sign_in);
        btnSignup = (Button) findViewById(R.id.btn_sign_up);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpClicked();
            }
        });//btnSignUp close

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInClicked();
            }
        });//btnSignIn close

    }//end of onCreate()

    private void signInClicked() {


        mDatabaseUsers.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(edtuserName.getText().toString()).exists()) {
                    if (!edtuserName.getText().toString().isEmpty()) {
                        User login = dataSnapshot.child(edtuserName.getText().toString()).getValue(User.class);
                        if (login.getPassword().equals(edtPassword.getText().toString())) {


                            Intent homeActivity = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(homeActivity);
                            finish();

                        } else {
                            Toast.makeText(MainActivity.this, "Wrong Input", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Enter Input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Does not exists in database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void signUpClicked() {
        try {


            LayoutInflater layoutInflater = getLayoutInflater();
            View sign_up_layout = layoutInflater.inflate(R.layout.layout_sign_up, null);

            edtNewuserName = (MaterialEditText) sign_up_layout.findViewById(R.id.edtNewuserName);
            edtNewPassword = (MaterialEditText) sign_up_layout.findViewById(R.id.edtNewPassword);
            edtNewBranch = (MaterialEditText) sign_up_layout.findViewById(R.id.edtNewBranch);

            spnNewSelectUser = (Spinner) sign_up_layout.findViewById(R.id.spnNewSelectUser);
            spnNewSemester = (Spinner) sign_up_layout.findViewById(R.id.spnNewSemester);
            spnNewSection = (Spinner) sign_up_layout.findViewById(R.id.spnNewSection);

            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Sign Up")
                    .setView(sign_up_layout)
                    .setIcon(R.drawable.ic_account_circle_black_24dp)
                    .setMessage("Please Fill in the Details")
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (spnNewSelectUser.getSelectedItem().toString().equals("Student")) {
                                user = User.instaceOfStudent(edtNewuserName.getText().toString(),
                                        spnNewSelectUser.getSelectedItem().toString(),
                                        edtNewBranch.getText().toString(), edtNewPassword.getText().toString(),
                                        spnNewSemester.getSelectedItem().toString(), spnNewSection.getSelectedItem().toString());
                            } else {
                                user = User.instanceOdExaminer(edtNewuserName.getText().toString(),
                                        spnNewSelectUser.getSelectedItem().toString(), edtNewBranch.getText().toString(),
                                        edtNewPassword.getText().toString());
                            }
                            mDatabaseUsers.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {


                                    if (dataSnapshot.child(user.getuserName()).exists()) {


                                        Toast.makeText(getApplicationContext(), "User Already Exist", Toast.LENGTH_LONG).show();
                                    } else {
                                        mDatabaseUsers.child(user.getuserName()).setValue(user);
                                        Toast.makeText(getApplicationContext(), "User Registration Completed", Toast.LENGTH_LONG).show();
                                    }

                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                }
                            });
                            dialog.dismiss();

                        }
                    });
            alertDialog.show();
            //setLayoutonFragment();
        } catch (Exception e) {
            Log.v("", "" + e);
        }
    }


}//end of class
