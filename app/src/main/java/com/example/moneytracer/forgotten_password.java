package com.example.moneytracer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class forgotten_password extends AppCompatActivity {
    private Button button_next_button_forgotten_password;
    private EditText inputMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);


        inputMobile = (EditText)findViewById(R.id.phone_bar_forgotten_password);


        button_next_button_forgotten_password = (Button) findViewById(R.id.next_button_forgotten_password);
        button_next_button_forgotten_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!inputMobile.getText().toString().trim().isEmpty()){


                    if((inputMobile.getText().toString().trim()).length()==11){

                        button_next_button_forgotten_password.setVisibility(View.INVISIBLE);
                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+88" + inputMobile.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                forgotten_password.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        button_next_button_forgotten_password.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        button_next_button_forgotten_password.setVisibility(View.VISIBLE);
                                        Toast.makeText(forgotten_password.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String s,@NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        button_next_button_forgotten_password.setVisibility(View.VISIBLE);
                                        Intent intent2 = new Intent(forgotten_password.this, verifyotp.class);
                                        intent2.putExtra("mobile",inputMobile.getText().toString());
                                        startActivity(intent2);
                                    }
                                }
                        );

                    }else{
                        Toast.makeText(forgotten_password.this,"Enter Correct Number",Toast.LENGTH_SHORT).show();
                    }



                }else{
                    Toast.makeText(forgotten_password.this,"Enter Number",Toast.LENGTH_SHORT).show();
                }





            }
        });
    }


}