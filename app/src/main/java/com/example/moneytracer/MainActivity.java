package com.example.moneytracer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    private Button button_signup;
    private Button button_forgotten_password;
    private Button button_signin;
    private EditText logPhone, logPassword;
    static String currentUserID;


    //disavble backbutton
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please sign in", Toast.LENGTH_SHORT).show();
    }

    CheckBox remember_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        logPhone = (EditText)findViewById(R.id.phone_bar);
        logPassword = (EditText)findViewById(R.id.password_bar);

        button_signin = (Button) findViewById(R.id.signin_button);
        button_signup = (Button) findViewById(R.id.signup_button);
       // button_forgotten_password = (Button) findViewById(R.id.forgotten_password_button);

        remember_me = (CheckBox) findViewById(R.id.RememberMe);



        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");

        if(checkbox.equals("true")){
            Intent intent_chekbox = new Intent(MainActivity.this, home_page.class);
            startActivity(intent_chekbox);

        }else if(checkbox.equals("false")){
            Toast.makeText(this,"Please Sign In",Toast.LENGTH_SHORT).show();
        }


        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensign_up();

            }
        });

        remember_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                    Toast.makeText(MainActivity.this,"Checked",Toast.LENGTH_SHORT).show();

                }else if(!compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                    Toast.makeText(MainActivity.this,"Unchecked",Toast.LENGTH_SHORT).show();

                }
            }
        });

//        button_forgotten_password.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openforgotten_password();
//
//            }
//        });


        button_signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                 loginuser();
            }

        });



    }
    public void opensign_up() {
        Intent intent = new Intent(MainActivity.this, sign_up.class);
        startActivity(intent);
    }

    public void openforgotten_password() {
        Intent intent1 = new Intent(MainActivity.this, forgotten_password.class);
        startActivity(intent1);
    }

    private boolean validatePhoneLogin(){

        String val = logPhone.getText().toString().trim();
        if (val.isEmpty()){
            logPhone.setError("Field cannot be empty");
            return false;

        }else{
            logPhone.setError(null);
            return true;
        }
    }


    private boolean validatePasswordLogin(){

        String val = logPassword.getText().toString().trim();

        if(val.isEmpty()){
            logPassword.setError("Field cannot be empty");
            return false;

        }else{
            logPassword.setError(null);
            return true;
        }
    }

    public void loginuser(){

        isUser();
    }

    private void isUser(){

        String enterPhone = logPhone.getText().toString();
        String enterPassword = logPassword.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkPhone = reference.orderByChild("phone").equalTo(enterPhone);

        checkPhone.addListenerForSingleValueEvent(new ValueEventListener()
        {

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists()){
                    logPhone.setError(null);
                    String passwordfromdb = datasnapshot.child(enterPhone).child("password").getValue(String.class);

                    if(passwordfromdb.equals(enterPassword)){

                        logPhone.setError(null);
                        currentUserID = logPhone.getText().toString().trim();
                        Intent intent2 = new Intent(getApplicationContext(),home_page.class);
                        startActivity(intent2);


                    }else{
                        logPassword.setError("Invalid Password");
                        logPassword.requestFocus();
                    }
                }else{
                    logPhone.setError("Invalid Number");
                    logPhone.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }



}