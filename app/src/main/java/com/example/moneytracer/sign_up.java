package com.example.moneytracer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up extends AppCompatActivity {
    private Button button_signup_signup;
    private EditText Name;
    private EditText Phone;
    private EditText Email;
    private EditText Password;

    private double homepage_show_debt ;
    private double homepage_total_balance ;
    private double homepage_current_balance ;
    private double homepage_current_expense ;

    private String name;
    private String email;
    private String phone;
    private String password;

    FirebaseDatabase rootNode;
    DatabaseReference reference;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name =(EditText) findViewById(R.id.name_bar_signup);
        Email =(EditText) findViewById(R.id.email_bar_signup);
        Password =(EditText) findViewById(R.id.password_bar_signup);
        Phone =(EditText) findViewById(R.id.phone_bar_signup);



        button_signup_signup = (Button) findViewById(R.id.signup_button_signup);

        button_signup_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");


                name = Name.getText().toString();
                email = Email.getText().toString();
                phone =Phone.getText().toString();
                password = Password.getText().toString();

                homepage_show_debt = 0;
                homepage_total_balance = 0;
                homepage_current_balance = 0;
                homepage_current_expense = 0;

                UserHelperClass helperClass  = new UserHelperClass(name, email, phone, password,homepage_show_debt,homepage_total_balance,homepage_current_balance,homepage_current_expense);

                reference.child(phone).setValue(helperClass);





               if(name.isEmpty()){
                    Name.setError("Name Is Required");
                    return;
                }
                if(email.isEmpty()){
                    Email.setError("Email Is Required");
                    return;
                }

                if(phone.isEmpty()){

                    Phone.setError("Phone Is Required");
                    return;
                }

                if(password.isEmpty()){

                    Password.setError("Password Is Required");
                    return;
                }



                Toast.makeText(sign_up.this,"Data Recieved", Toast.LENGTH_SHORT).show();
                // opensignup_button_signup();
                Intent intent = new Intent(sign_up.this, MainActivity.class);
                startActivity(intent);


            }
        });


    }


    public void opensignup_button_signup() {



    }


}