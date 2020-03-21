package com.example.paras.firstfirebaseapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private EditText email_id,pass_id;
    private Button login_id;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaselistener;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_id = (EditText)findViewById(R.id.email_id);
        pass_id = (EditText)findViewById(R.id.pass_id);
        login_id = (Button)findViewById(R.id.login_id);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaselistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {

                firebaseUser = firebaseAuth.getCurrentUser();
                if(firebaseUser!=null)
                {
                    Toast.makeText(MainActivity.this, "Already sign in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,sendActivity.class));
                    finish();
                }
                else
                    Toast.makeText(MainActivity.this,"Please sing in",Toast.LENGTH_SHORT).show();

            }
        };

        login_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String email = email_id.getText().toString().trim();
                String password = pass_id.getText().toString().trim();

                if(!email.isEmpty() && !password.isEmpty())
                {
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {

                            if(task.isSuccessful())
                            {
                                Toast.makeText(MainActivity.this, "Successfully Sign in!", Toast.LENGTH_SHORT).show();
                            }
                            else
                                Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();


                        }
                    });
                }
                else
                    {
                        Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaselistener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (firebaselistener != null)
            firebaseAuth.removeAuthStateListener(firebaselistener);
    }
}
