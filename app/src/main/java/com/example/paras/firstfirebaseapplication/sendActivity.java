package com.example.paras.firstfirebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class sendActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name_id,email_send_id,pass_send_id,age_send_id,phone_send_id;
    private Button send_id,read_send_id;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Details");

        name_id = (EditText)findViewById(R.id.name_id);
        email_send_id = (EditText)findViewById(R.id.email_send_id);
        pass_send_id= (EditText)findViewById(R.id.pass_send_id);
        age_send_id = (EditText)findViewById(R.id.age_send_id);
        phone_send_id = (EditText)findViewById(R.id.phone_send_id);
        send_id = (Button) findViewById(R.id.send_id);
        read_send_id = (Button) findViewById(R.id.read_send_id);

        send_id.setOnClickListener(this);
        read_send_id.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.signout_id)
        {
//            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
            startActivity(new Intent(sendActivity.this,MainActivity.class));
            finish();
            Toast.makeText(this, "Successfully signed out", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.send_id:
//                Toast.makeText(this, "send clicked", Toast.LENGTH_SHORT).show();

                final String name = name_id.getText().toString().trim();
                String email = email_send_id.getText().toString().trim();
                String password = pass_send_id.getText().toString().trim();
                String age = age_send_id.getText().toString().trim();
                String number = phone_send_id.getText().toString().trim();

                if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !age.isEmpty() && !number.isEmpty())
                {

                    DatabaseReference reference = databaseReference.push();
                    Map<String,String> map = new HashMap<>();
                    map.put("name_id",name);
                    map.put("email_send_id",email);
                    map.put("pass_send_id",password);
                    map.put("age_send_id",age);
                    map.put("phone_send_id",number);

                    reference.setValue(map).addOnSuccessListener(this, new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid)
                        {
                            Toast.makeText(sendActivity.this, "Successfully Send", Toast.LENGTH_SHORT).show();
                            name_id.setText("");
                            email_send_id.setText("");
                            age_send_id.setText("");
                            phone_send_id.setText("");
                            pass_send_id.setText("");
                        }
                    });

                }
                else
                    {
                        Toast.makeText(this, "Invalid Fill The Blocks", Toast.LENGTH_SHORT).show();
                    }

                break;


            case R.id.read_send_id:
//                Toast.makeText(this, "read clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(sendActivity.this,readActivity.class));
                finish();
                break;
        }

    }
}
