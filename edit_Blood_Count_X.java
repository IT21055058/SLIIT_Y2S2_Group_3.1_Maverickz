package com.maverickz.mad_project_hope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class edit_Blood_Count_X extends AppCompatActivity {

    private EditText abP, abM, oP, oM, aP, aM, bP, bM ;
    private Button saveedit,editBackBloodBtn;
    DatabaseReference dbref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://blood-hope-1f587-default-rtdb.firebaseio.com/");

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_blood_count_x);

        abP = findViewById(R.id.editABplus);
        editBackBloodBtn = findViewById(R.id.editBackBloodBtn);
        abM = findViewById(R.id.editABminus);
        oP = findViewById(R.id.editOplus);
        oM = findViewById(R.id.editOminus);
        aP = findViewById(R.id.editAplus);
        aM = findViewById(R.id.editAminus);
        bP = findViewById(R.id.editBplus);
        bM = findViewById(R.id.editBminus);

        saveedit = findViewById(R.id.editBloodBtn);

        editBackBloodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(edit_Blood_Count_X.this, Home_hospital.class);
                startActivity(i4);
                finish();
            }
        });

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        final String id = sharedPreferences.getString(KEY_NAME,null);

        if(id.isEmpty()){

        }else {
            dbref.child("hospital").addListenerForSingleValueEvent(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    //check email
                    if (snapshot.hasChild(id)) {
//                        type.setText(snapshot.child("type").getValue().toString());
                        abP.setText(snapshot.child(id).child("AB+").getValue(String.class));
                        abM.setText(snapshot.child(id).child("AB-").getValue(String.class));
                        oP.setText(snapshot.child(id).child("O+").getValue(String.class));
                        oM.setText(snapshot.child(id).child("O-").getValue(String.class));
                        aP.setText(snapshot.child(id).child("A+").getValue(String.class));
                        aM.setText(snapshot.child(id).child("A-").getValue(String.class));
                        bP.setText(snapshot.child(id).child("B+").getValue(String.class));
                        bM.setText(snapshot.child(id).child("B-").getValue(String.class));


                    } else {
                        Toast.makeText(edit_Blood_Count_X.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        saveedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                    String name2 = name.getText().toString();
                String abP2 = abP.getText().toString();
                String abM2 = abM.getText().toString();
                String oP2 = oP.getText().toString();
                String oM2 = oM.getText().toString();
                String aP2 = aP.getText().toString();
                String aM2 = aM.getText().toString();
                String bP2 = bP.getText().toString();
                String bM2 = bM.getText().toString();

                    dbref.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            dbref.child("hospital").child(id).child("AB+").setValue(abP2);
                            dbref.child("hospital").child(id).child("AB-").setValue(abM2);
                            dbref.child("hospital").child(id).child("O+").setValue(oP2);
                            dbref.child("hospital").child(id).child("O-").setValue(oM2);
                            dbref.child("hospital").child(id).child("A+").setValue(aP2);
                            dbref.child("hospital").child(id).child("A-").setValue(aM2);
                            dbref.child("hospital").child(id).child("B+").setValue(bP2);
                            dbref.child("hospital").child(id).child("B-").setValue(bM2);




                            Toast.makeText(edit_Blood_Count_X.this , "New Data Stored Successfully" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(edit_Blood_Count_X.this , Home_hospital.class));
                            finish();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }






        });
    }
}