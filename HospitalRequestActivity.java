package com.maverickz.mad_project_hope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class HospitalRequestActivity extends AppCompatActivity {

    private TextInputEditText hospitalrequest;
    private Button idhosrequestbtn,idpostbackbtn;

    DatabaseReference dbref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://blood-hope-1f587-default-rtdb.firebaseio.com/");

    public HospitalRequestActivity() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_request);

        hospitalrequest = findViewById(R.id.hospitalrequest);
        idhosrequestbtn = findViewById(R.id.idhosrequestbtn);
        idpostbackbtn = findViewById(R.id.idrequstbackbtn);


        idhosrequestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String hospitalrequestdata = hospitalrequest.getText().toString().trim();

                idpostbackbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(HospitalRequestActivity.this, Home_hospital.class);
                        startActivity(i);
                        finish();
                    }
                });

                if(TextUtils.isEmpty(hospitalrequestdata)){
                    hospitalrequest.setError("Enter your Request....");
                    return;
                }else {

                    dbref.child("request").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                                dbref.child("request").setValue(hospitalrequestdata);

                                Toast.makeText(HospitalRequestActivity.this, "Successfully Requested....", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(HospitalRequestActivity.this, Home_hospital.class));
                                finish();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {}


            });
        }


    }
});}}