package com.example.moneytracer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class verifyotp extends AppCompatActivity {

    private EditText inputcode1, inputcode2, inputcode3, inputcode4, inputcode5, inputcode6;
     private  Button verifybutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyotp);

        verifybutton= (Button)findViewById(R.id.verify_button_verifyotp);

        inputcode1 =(EditText)findViewById(R.id.inputcode1);
        inputcode2 =(EditText)findViewById(R.id.inputcode2);
        inputcode3 =(EditText)findViewById(R.id.inputcode3);
        inputcode4 =(EditText)findViewById(R.id.inputcode4);
        inputcode5 =(EditText)findViewById(R.id.inputcode5);
        inputcode6 =(EditText)findViewById(R.id.inputcode6);

        TextView textView= findViewById(R.id.show_number);
        textView.setText(String.format(
                getIntent().getStringExtra("mobile")
        ));

        verifybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputcode1.getText().toString().trim().isEmpty() && !inputcode2.getText().toString().trim().isEmpty() && !inputcode3.getText().toString().trim().isEmpty() && !inputcode4.getText().toString().trim().isEmpty() && !inputcode5.getText().toString().trim().isEmpty() && !inputcode6.getText().toString().trim().isEmpty()){
                        String entercodeotp = inputcode1.getText().toString() +
                                inputcode2.getText().toString() +
                                inputcode3.getText().toString() +
                                inputcode4.getText().toString() +
                                inputcode5.getText().toString() +
                                inputcode6.getText().toString();
                        
                    //Toast.makeText(verifyotp.this,"verify OTP",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(verifyotp.this,"please enter all number",Toast.LENGTH_SHORT).show();
                }
            }
        });

        setupOTPInputs();
    }

    private void setupOTPInputs(){
        inputcode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    inputcode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputcode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    inputcode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputcode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    inputcode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputcode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    inputcode5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputcode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    inputcode6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}